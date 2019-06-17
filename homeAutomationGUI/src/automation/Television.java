package automation;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Television extends JFrame implements ActionListener
{
	String[] channels = {"Ch.1", "Ch.2", "Ch.3"};
	JComboBox tvSelect = new JComboBox(channels);
	JLabel label = new JLabel();
	
	protected String tvOn, tvOff;//
	
	public Television()
	{
		setLayout(new FlowLayout());
		setSize(500,350);
		setTitle("TV");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		tvSelect.setSelectedIndex(0);
		tvSelect.addActionListener(this);
		add(tvSelect);
		add(label);
	}

	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		try 
		{
			URL url = new URL("http://vignette2.wikia.nocookie.net/powerlisting/images/3/3f/Neogohan_SSJ3_Goku.gif/revision/latest?cb=20170228035840");
			URL url2 = new URL("https://az616578.vo.msecnd.net/files/2017/01/07/636193592097073188-1925973375_star-wars-movie-marathon-review-disneyexaminer-im-your-father-darth-vader.gif");
			URL url3 = new URL("http://data.photofunky.net/output/image/a/2/4/0/a240a8/photofunky.gif");
			
			  Icon icon = new ImageIcon(url);
			  Icon icon2 = new ImageIcon(url2);
			  Icon icon3 = new ImageIcon(url3);
			  
			  if(e.getSource() == tvSelect)
			  {
				  JComboBox cb = (JComboBox)e.getSource();
				  String selectedChannel = (String)cb.getSelectedItem();
				  
				  switch(selectedChannel)
				  {
				  	case "Ch.1": label.setIcon(icon);
				  		break;
				  		
				  	case "Ch.2": label.setIcon(icon2);
				  		break;
				  	
				  	case "Ch.3": label.setIcon(icon3);
				  		break;
				  	
				  	default: label.setText("There seemed to be an error.");	
				  }
			  }
			  
			  
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
			
		}
		
	}
	
	//getters
	public String getOnTv()
	{
		return tvOn;
	}
	
	public String getTvOff()
	{
		return tvOff;
	}
	
	//setters
	public void setTvOn(String tvOn)
	{
		this.tvOn = tvOn;
	}
	
	public void setTvOff(String tvOff)
	{
		this.tvOff = tvOff;
	}
	
	public static void main(String[] args)
	{
		Television fr = new Television();
		//centerFrame(fr);
		fr.setVisible(true);
		
	}
	
}