package designpattern.jun.com.designpattern.Builder.software_development;

/**
 * @Description 一个放荡不羁的程序员「具体的建造者」
 * @Creator TigerChain（创建者）
 */
public class DeveloperA implements CTOBuilder {

    private SoftWareProduct softWareProduct = new SoftWareProduct() ;

    @Override
    public void caiJiXuQiu() {
        softWareProduct.setCaiJiXuqiu("本软件要实现地理位置定位功能");
    }

    @Override
    public void huaJiaGouTu() {
        softWareProduct.setHuaJiaGouTu("架构图应该采用 MVP 模式");
    }

    @Override
    public void daJianGuangJia() {
        softWareProduct.setDaJianGuangJia("把对应的架构图转化成代码");
    }

    @Override
    public void bianXieMoKuai() {
        softWareProduct.setBianXieMoKuai("使用高德地图实现定位功能，编写出基本模版 \n 完工交作业");
    }

    @Override
    public SoftWareProduct getSoftWare() {
        return this.softWareProduct;
    }
}
