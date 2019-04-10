package cn.guimei_mall.service;

import cn.guimei_mall.entity.Announcement;

import java.util.List;

public interface AnnouncementService {
    /**
     * 查询全部
     */
    List<Announcement> getAnnounce();
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
     * 添加、级联查询
     */
    int addAnn(Announcement ann);
}