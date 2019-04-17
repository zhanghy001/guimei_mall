package cn.guimei_mall.dao;

import cn.guimei_mall.entity.Announcement;

import java.util.List;
/**
 * 公告
 * Hao
 */
public interface AnnouncementDao {
    /**
     * 查询全部
     */
    List<Announcement> getAnnounce(int pageCurrentNo,int pagesize);
    /**
     * 根据id查询
     */
    Announcement getIdAnnounce(int id);
    /**
     * 修改、
     */
    int updateNews(Announcement ann, int id);
    /**
     * 删除、
     */
    int delectAnn(int id);
    /**
     * 总条数
     */
    int getCount();
    /**
     * 添加、级联查询
     */
    int addAnn(Announcement ann);
    /**
     * 分页
     */
    int getTotalCount();
}
