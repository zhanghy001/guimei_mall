package cn.guimei_mall.util;

import java.util.List;

public class PageSupport {
    private int pagesize;  //页面容量
    private int pageCurrentNo;  //当前页码
    private int totalCount;   //总数量
    private int totalPages;   //总页数
    private List<?> list;

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getPageCurrentNo() {
        return pageCurrentNo;
    }

    public void setPageCurrentNo(int pageCurrentNo) {
        this.pageCurrentNo = pageCurrentNo;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPages() {
        if(totalCount%pagesize==0){
            this.totalPages=totalCount/pagesize;
        }else{
            this.totalPages=totalCount/pagesize+1;
        }
        return this.totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
