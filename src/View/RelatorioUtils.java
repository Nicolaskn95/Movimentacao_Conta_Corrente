// Arquivo: RelatorioUtils.java
package View; // Ou o pacote que preferir para suas classes utilitárias

// Imports necessários para os métodos
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Component;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class RelatorioUtils {

    /**
     * Gera um arquivo PDF a partir dos dados de uma JTable.
     * @param parentComponent O componente pai para os diálogos (geralmente o JFrame, use 'this').
     * @param tabela A JTable da qual os dados serão extraídos.
     * @param titulo O título que aparecerá no topo do relatório PDF.
     */
    public static void gerarRelatorioPDF(Component parentComponent, JTable tabela, String titulo) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar Relatório como PDF");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos PDF", "pdf"));

        int userSelection = fileChooser.showSaveDialog(parentComponent);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".pdf")) {
                filePath += ".pdf";
            }

            Document document = new Document(PageSize.A4.rotate()); // Deixei em modo paisagem para caber mais colunas

            try {
                PdfWriter.getInstance(document, new FileOutputStream(filePath));
                document.open();

                Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
                Paragraph titlePara = new Paragraph(titulo, titleFont);
                titlePara.setAlignment(Element.ALIGN_CENTER);
                document.add(titlePara);
                document.add(new Paragraph(" "));

                PdfPTable pdfTable = new PdfPTable(tabela.getColumnCount());
                pdfTable.setWidthPercentage(100);

                Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                for (int i = 0; i < tabela.getColumnCount(); i++) {
                    PdfPCell headerCell = new PdfPCell(new Phrase(tabela.getColumnName(i), headerFont));
                    headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfTable.addCell(headerCell);
                }

                for (int rows = 0; rows < tabela.getRowCount(); rows++) {
                    for (int cols = 0; cols < tabela.getColumnCount(); cols++) {
                        Object cellValue = tabela.getValueAt(rows, cols);
                        String cellText = (cellValue == null) ? "" : cellValue.toString();
                        pdfTable.addCell(cellText);
                    }
                }

                document.add(pdfTable);
                JOptionPane.showMessageDialog(parentComponent, "Relatório PDF gerado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);

            } catch (DocumentException | FileNotFoundException ex) {
                System.err.println("Erro ao gerar o PDF: " + ex.getMessage());
                JOptionPane.showMessageDialog(parentComponent, "Ocorreu um erro ao gerar o PDF.", "Erro de Geração", JOptionPane.ERROR_MESSAGE);
            } finally {
                if (document.isOpen()) {
                    document.close();
                }
            }
        } else {
            JOptionPane.showMessageDialog(parentComponent, "A geração do PDF foi cancelada.", "Cancelado", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Ajusta a largura das colunas de uma JTable para caber o conteúdo.
     * @param table A JTable a ser ajustada.
     */
    public static void ajustarTabela(JTable table) {
        table.setRowHeight(25);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel columnModel = table.getColumnModel();

        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15;
            TableColumn tableColumn = columnModel.getColumn(column);
            Component headerComp = table.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(table, tableColumn.getHeaderValue(), false, false, 0, column);
            width = Math.max(width, headerComp.getPreferredSize().width);

            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(width, comp.getPreferredSize().width + 1);
            }
            
            tableColumn.setPreferredWidth(width + 15);
        }
    }
}