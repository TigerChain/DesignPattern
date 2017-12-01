package designpattern.jun.com.designpattern.Builder.software_development;

/**
 * @Description 产品经理充当 Director
 * @Creator TigerChain（创建者）
 */
public class PMDirector {

    private CTOBuilder builder ;

    public void director(CTOBuilder builder){
        this.builder = builder ;
        builder.caiJiXuQiu();
        builder.huaJiaGouTu();
        builder.daJianGuangJia();
        builder.bianXieMoKuai();
    }

    public SoftWareProduct getSoftWare(){
        return this.builder.getSoftWare()!=null?this.builder.getSoftWare():null ;
    }
}
