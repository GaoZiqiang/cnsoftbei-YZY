package cn.edu.sdut.wx4j;

public Menu getSampleMenu() {

    Menu m = new Menu();
    
    Button b1 = new Button();
    b1.setName("客户服务");
    ViewButton b11 = new ViewButton();
    b11.setName("测试1");
    b11.setType(ButtonType.VIEW);
    b11.setUrl("http://www.zhour.net");
    ViewButton b12 = new ViewButton();
    b12.setName("测试2");
    b12.setType(ButtonType.VIEW);
    b12.setUrl("http://www.zhour.net");
    ViewButton b13 = new ViewButton();
    b13.setName("test1");
    b13.setType(ButtonType.VIEW);
    b13.setUrl("http://www.zhour.net");
    ViewButton b14 = new ViewButton();
    b14.setName("test2");
    b14.setType(ButtonType.VIEW);

    b14.setUrl("http://www.zhour.net");
    b1.setSub_button(new Button[] { b11, b12, b13, b14 });

    Button b2 = new Button();
    b2.setName("infomation");
    ViewButton b21 = new ViewButton();
    b21.setName("官网");
    b21.setType(ButtonType.VIEW);
    b21.setUrl("http://www.huapengfei.com");
    ViewButton b22 = new ViewButton();
    b22.setName("APP");
    b22.setType(ButtonType.VIEW);
    b22.setUrl("http://www.zhour.net");

    b2.setSub_button(new Button[] { b21, b22 });

    ViewButton b3 = new ViewButton();
    b3.setName("联系我们");
    b3.setType(ButtonType.VIEW);
    b3.setUrl("http://www.zhour.net");

    m.setButton(new Button[] { b1, b2, b3 });
    return m;
}