import java.io.IOException;

import jxl.Cell;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class SkillVO {
	public int id;
	public String name;
	public String gift;
	public String icon;
	public boolean isPassiveSkill;
	/**
	 * 习得条件 如果isPassiveSkill==true 则为技能点数,否则为天赋等级
	 */
	public int learnCondition;

	public SkillVO(Cell[] cells) {
		id = Integer.parseInt(cells[0].getContents());
		name = cells[1].getContents();
		gift = cells[2].getContents();
		learnCondition = Integer.parseInt(cells[3].getContents());
		isPassiveSkill = (cells[4].getContents().charAt(0)=='1');
		icon = cells[5]!=null? cells[5].getContents():"";

	}

	public Document toXML() throws IOException {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("skill");// 创建根节点
		root.addAttribute("name", name);
		root.addAttribute("gift", gift);
		root.addAttribute("id", "" + id);
		root.addAttribute("isPassiveSkill", isPassiveSkill ? "true" : "false");
		root.addAttribute("gift", gift);
		root.addAttribute("learnCondition", ""+learnCondition);
		root.addAttribute("icon", ""+icon);
		
//		System.out.print(document.getRootElement().getName());
		return document;
	}
}
