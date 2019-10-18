package com.web.util;

/**
 * @ClassName PageUtil
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/16 19:19
 * @Version 1.0
 *
 * Oracle分页工具类
 **/
public class PageUtil {
    private String cpage;
    private Integer pageSize;// 每页显示数
    private Integer count;// 总记录

    private Integer pageindex;// 当前页
    private Integer pagewy;// 尾页
    private Integer pagelast;// 下一页
    private Integer pagefirst;// 上一页
    private Integer start;// 起始位置
    private Integer end;// 结束位置

    private String mohu;

    // 尾页
    public void listpagewy() {
        pagewy = (int) Math.ceil((double)count / (double)pageSize);
    }

    // 初始化
    public void listpageindex() {
        cpage = cpage == null ? "1" : cpage;
        Integer page = Integer.parseInt(cpage);
        if (page < 1) {
            page = 1;
        }
        pageindex = page;
    }

    // 下一页
    public void listpagelast() {
        if (pageindex >= pagewy) {
            pagelast = pageindex;
        } else {
            pagelast = pageindex + 1;
        }
    }

    // 上一页
    public void listpagefirst() {
        if (pageindex <= 1) {
            pagefirst = 1;
        } else {
            pagefirst = pageindex - 1;
        }
    }

    // 起始位置
    public void liststart() {
        start = (pageindex - 1 )* pageSize;
    }

    // 结束位置
    public void listend() {
        end = pageindex * pageSize + 1;
    }

    public PageUtil(String cpage, Integer pageSize, Integer count) {
        super();
        this.cpage = cpage;
        this.pageSize = pageSize;
        this.count = count;
        listpageindex();// 初始化
        listpagefirst();// 上一页
        listpagewy();// 尾页
        listpagelast();// 下一页
        liststart();// 起始位置
        listend();// 结束位置
    }

    public String getCpage() {
        return cpage;
    }

    public Integer getPageindex() {
        return pageindex;
    }

    public Integer getPagewy() {
        return pagewy;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getPagelast() {
        return pagelast;
    }

    public Integer getPagefirst() {
        return pagefirst;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }

    public String getMohu() {
        return mohu;
    }

    public void setMohu(String mohu) {
        this.mohu = mohu;
    }
}
