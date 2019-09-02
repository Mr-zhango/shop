package cn.myfreecloud.shop.basic;

import java.io.Serializable;
import java.util.List;

/**
 * 基础分页对象
 * @param <T>
 */
public class MyPage<T> implements Serializable {

    private static final long serialVersionUID = -1429970133830940214L;

    /**
     * 总条数
     */
    private Integer totalNum;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 每页条数
     */
    private Integer pageSize;
    /**
     * 当前页码
     */
    private Integer pageIndex;
    /**
     * 当前页从第几条开始查
     */
    private Integer queryIndex;

    List<T> pageList;

    public static MyPage pagination(Integer totalNum, Integer pageSize, Integer pageIndex){
        MyPage page = new MyPage();
        page.setTotalNum(totalNum);
        Integer totalPage = (int) Math.ceil(totalNum*1.0/pageSize);
        page.setTotalPage(totalPage);
        page.setPageIndex(pageIndex);
        page.setPageSize(pageSize);
        page.setQueryIndex(pageSize * (pageIndex - 1));
        return page;
    }


    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalPage() {
        return (int) Math.ceil(totalNum*1.0/pageSize);
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getQueryIndex() {
        return queryIndex;
    }

    public void setQueryIndex(Integer queryIndex) {
        this.queryIndex = queryIndex;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }
}
