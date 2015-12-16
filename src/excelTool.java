import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

public class excelTool {

	// static String sourcefile ="./skill_cn.xls";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// 构建Workbook对象, 只读Workbook对象
			// 直接从本地文件创建Workbook
			// 从输入流创建Workbook
			File f = new File("./");
			File[] fls = f.listFiles();
			for (int i = 0; i < fls.length; i++) {
				String fn = fls[i].getName();
				if (fn.indexOf(".xls") != -1 ) {

					System.out.print(fls[i].getAbsolutePath()+"\n");
					InputStream is = new FileInputStream(
							fls[i].getAbsolutePath());
					jxl.Workbook rwb = Workbook.getWorkbook(is);
					Sheet sht = rwb.getSheet("skill");
					int rowNum = sht.getRows();
					Document document = DocumentHelper.createDocument();
					Element root = document.addElement("skills");// 创建根节点
					for (int j = 0; j < rowNum; j++) {
						if (j < 2)
							continue;
						Cell[] cells = sht.getRow(j);
						WushuSkillVO vo = new WushuSkillVO(cells);
						// System.out.print(vo.name+"\n");
						root.add(vo.toXML().getRootElement());
					}
					XMLWriter writer = new XMLWriter(new FileWriter(
							fn.split("[.]")[0] + ".xml"));
					writer.write(document);
					writer.close();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
