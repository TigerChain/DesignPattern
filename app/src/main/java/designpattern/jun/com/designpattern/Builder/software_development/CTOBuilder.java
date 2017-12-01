package designpattern.jun.com.designpattern.Builder.software_development;

/**
 * @Description 技术主管是一个抽象的建造者
 * @Creator TigerChain（创建者）
 */
public interface CTOBuilder {
    void caiJiXuQiu() ;
    void huaJiaGouTu() ;
    void daJianGuangJia() ;
    void bianXieMoKuai() ;

    SoftWareProduct getSoftWare() ;
}
