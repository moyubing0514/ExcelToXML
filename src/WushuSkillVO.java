import java.io.IOException;

import jxl.Cell;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class WushuSkillVO {
	public int id;
	public String name;
	public String gift;
	public String icon;
	public String words;

	public WushuSkillVO(Cell[] cells) {
		id = Integer.parseInt(cells[0].getContents());
		name = cells[1].getContents();
		gift = cells[2].getContents();
		words = cells[4].getContents();
		icon = cells[3].getContents();

	}

	public Document toXML() throws IOException {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("skill");// 创建根节点
		root.addAttribute("name", name);
		root.addAttribute("gift", gift);
		root.addAttribute("id", "" + id);
		root.addAttribute("words", "" + words);
		root.addAttribute("icon", "" + icon);
		// System.out.print(document.getRootElement().getName());
		return document;
	}
}
