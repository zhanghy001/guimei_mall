package cn.guimei_mall.service.Impl;

import cn.guimei_mall.dao.AnnouncementDao;
import cn.guimei_mall.dao.Impl.AnnouncementDaoImpl;
import cn.guimei_mall.entity.Announcement;
import cn.guimei_mall.service.AnnouncementService;

import java.util.List;
/**
 * 公告
 * Hao
 */
public class AnnouncementServiceImpl implements AnnouncementService{
    AnnouncementDao announce =null;
    public AnnouncementServiceImpl() {
        announce = new AnnouncementDaoImpl();
    }

    @Override
    public List<Announcement> getAnnounce(int pageCurrentNo,int pageSize) {
        return announce.getAnnounce(pageCurrentNo,pageSize);
    }

    @Override
    public Announcement getIdAnnounce(int id) {
        return announce.getIdAnnounce(id);
    }

    @Override
    public int updateNews(Announcement ann, int id) {
        return announce.updateNews(ann,id);
    }

    @Override
    public int delectAnn(int id) {
        return announce.delectAnn(id);
    }

    @Override
    public int addAnn(Announcement ann) {
        return announce.addAnn(ann);
    }

    @Override
    public int getTotalCount() {
        return announce.getTotalCount();
    }
}
