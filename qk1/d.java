package qk1;

import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.animation.transition.TransitionBean;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.detail.FeedInteractiveData;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.util.am;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import in1.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class d extends ok1.a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a extends TypeToken<List<jn1.d>> {
        a() {
        }
    }

    @Nullable
    public static List<jn1.d> p(String str) {
        List<jn1.d> list = (List) new Gson().fromJson(str, new a().getType());
        if (list != null && list.size() > 0) {
            for (jn1.d dVar : list) {
                dVar.imageUrl = v(dVar.imageUrl);
                dVar.thumbnailUrl = v(dVar.thumbnailUrl);
            }
        }
        return list;
    }

    private void q(int i3) {
        e eVar;
        if (i3 != 0 || (eVar = (e) l()) == null) {
            return;
        }
        eVar.Z4();
    }

    private GuildFeedGalleryInitBean r(List<GuildFeedRichMediaData> list, int i3, int i16) {
        String tinyId;
        String channelId;
        String str;
        lj1.a aVar;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = new GuildFeedGalleryInitBean();
        String str2 = "";
        if (i16 != 0) {
            if (i16 == 1 && (aVar = (lj1.a) l()) != null) {
                String posterTinyId = aVar.getInitBean().getPosterTinyId();
                String guildId = aVar.getInitBean().getGuildId();
                String channelId2 = aVar.getInitBean().getChannelId();
                tinyId = posterTinyId;
                str2 = guildId;
                str = aVar.getInitBean().getFeedId();
                channelId = channelId2;
            }
            channelId = "";
            tinyId = channelId;
            str = tinyId;
        } else {
            e eVar = (e) l();
            if (eVar != null) {
                tinyId = eVar.getInitBean().getTinyId();
                String guildId2 = eVar.getInitBean().getGuildId();
                channelId = eVar.getInitBean().getChannelId();
                if (list != null && !list.isEmpty()) {
                    Iterator<GuildFeedRichMediaData> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().setVideoScreenPlay(false);
                    }
                }
                str = "";
                str2 = guildId2;
            }
            channelId = "";
            tinyId = channelId;
            str = tinyId;
        }
        guildFeedGalleryInitBean.setRichMediaDataList(list);
        guildFeedGalleryInitBean.setEnterPos(i3);
        guildFeedGalleryInitBean.setFromPage(i16);
        guildFeedGalleryInitBean.setGuildId(str2);
        guildFeedGalleryInitBean.setChannelId(channelId);
        guildFeedGalleryInitBean.setPosterId(tinyId);
        guildFeedGalleryInitBean.setFeedId(str);
        return guildFeedGalleryInitBean;
    }

    private void s(GuildFeedGalleryInitBean guildFeedGalleryInitBean) {
        GProStFeed gProStFeed = new GProStFeed();
        pk1.b l3 = l();
        if (l3 instanceof lj1.a) {
            lj1.a aVar = (lj1.a) l3;
            FeedInteractiveData feedInteractiveData = aVar.getFeedInteractiveData();
            gProStFeed.totalPrefer.preferStatus = feedInteractiveData.getPreferStatus();
            gProStFeed.totalPrefer.preferCountWithoutLike = feedInteractiveData.getPreferCount();
            gProStFeed.share.sharedCount = feedInteractiveData.getShareCount();
            gProStFeed.commentCount = feedInteractiveData.getCommentCount();
            GuildFeedDetailInitBean initBean = aVar.getInitBean();
            if (initBean != null) {
                gProStFeed.createTime = initBean.getCreateTime();
            }
        }
        GProStRichTextContent gProStRichTextContent = new GProStRichTextContent();
        gProStRichTextContent.textContent.text = guildFeedGalleryInitBean.getFeedTitle();
        gProStFeed.title.contents.add(gProStRichTextContent);
        gProStFeed.poster.idd = guildFeedGalleryInitBean.getPosterId();
        gProStFeed.poster.nick = guildFeedGalleryInitBean.getPosterNick();
        GProStUser gProStUser = gProStFeed.poster;
        gProStUser.nickFlag = 1;
        gProStUser.icon.iconUrl = guildFeedGalleryInitBean.getPosterAvatar();
        gProStFeed.feedType = 2;
        gProStFeed.idd = guildFeedGalleryInitBean.getFeedId();
        gProStFeed.channelInfo.sign.guildId = Long.parseLong(guildFeedGalleryInitBean.getGuildId());
        gProStFeed.channelInfo.sign.channelId = Long.parseLong(guildFeedGalleryInitBean.getChannelId());
        guildFeedGalleryInitBean.setFeed(gProStFeed);
        guildFeedGalleryInitBean.setTransStFeed(gProStFeed);
    }

    private TransitionBean t(jn1.d dVar) {
        if (dVar == null) {
            return null;
        }
        dVar.f410652x = cx.a((int) dVar.f410652x);
        dVar.f410653y = cx.a((int) dVar.f410653y);
        dVar.showWidth = cx.a(dVar.showWidth);
        dVar.showHeight = cx.a(dVar.showHeight);
        TransitionBean enterViewRect = new TransitionBean().setEnterViewRect((int) dVar.f410652x, (int) dVar.f410653y, dVar.showWidth, dVar.showHeight);
        int i3 = dVar.type;
        if (i3 == 1) {
            enterViewRect.setStImage(dVar.coverUrl, dVar.width, dVar.height);
        } else if (i3 == 0) {
            enterViewRect.setStImage(dVar.listThumbnailUrl, dVar.width, dVar.height);
        }
        enterViewRect.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return enterViewRect;
    }

    private boolean u(int i3) {
        if (i3 != 11 && i3 != 12 && i3 != 13) {
            return false;
        }
        return true;
    }

    private static String v(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("/guildFeedPublish/localMedia")) {
            return str.replace("/guildFeedPublish/localMedia", "");
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "showMedia";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        boolean z16;
        GuildFeedBaseInitBean detailInitBean;
        HashMap<String, String> discoverSearchDtParams;
        List<jn1.d> p16 = p(g("files"));
        if (bl.b(p16)) {
            return false;
        }
        int d16 = d("index");
        int d17 = d("fromPage");
        if (d("type") == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        String h16 = h("posterNickName", "");
        String h17 = h("posterId", "");
        String h18 = h("posterAvatar", "");
        String h19 = h("feedTitle", "");
        String h26 = h("guildId", "");
        String h27 = h("channelId", "");
        String h28 = h("feedId", "");
        GuildFeedGalleryInitBean r16 = r(am.c(p16), d16, d17);
        r16.setFeedTitle(h19);
        r16.setPosterAvatar(h18);
        r16.setPosterNick(h16);
        r16.setPosterId(h17);
        if (d17 == 2) {
            r16.setGuildId(h26);
            r16.setChannelId(h27);
            r16.setFeedId(h28);
        }
        if (l() != null && l().getInitBean() != null) {
            r16.setBusinessType(l().getInitBean().getBusinessType());
        }
        if (!p16.get(d16).isGif) {
            if (d16 >= 0 && d16 < p16.size()) {
                jn1.d dVar = p16.get(d16);
                r16.setTransitionBean(t(dVar));
                if (dVar != null && !TextUtils.isEmpty(dVar.videoUrl) && !dVar.videoUrl.startsWith("http")) {
                    r16.setShowMoreIcon(false);
                }
            }
            if (r16.getTransitionBean() != null) {
                r16.getTransitionBean().setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        }
        pk1.b l3 = l();
        if ((l3 instanceof lj1.a) && (detailInitBean = ((lj1.a) l3).getDetailInitBean()) != null) {
            r16.setImmersiveSource(detailInitBean.getImmersiveSource());
            r16.getAttrs().putAll(detailInitBean.getAttrs());
            r16.setJoinInfoParam(detailInitBean.getJoinInfoParam());
            if ((detailInitBean instanceof GuildFeedDetailInitBean) && (discoverSearchDtParams = ((GuildFeedDetailInitBean) detailInitBean).getDiscoverSearchDtParams()) != null && discoverSearchDtParams.containsKey(JumpGuildParam.EXTRA_KEY_TRACE_ID)) {
                r16.getAttrs().put(JumpGuildParam.EXTRA_KEY_TRACE_ID, discoverSearchDtParams.get(JumpGuildParam.EXTRA_KEY_TRACE_ID));
            }
            if (detailInitBean.getBusinessType() == 7) {
                r16.setTroopUin(detailInitBean.getTroopUin());
                r16.setTroopRole(detailInitBean.getTroopRole());
                if (!u(detailInitBean.getImmersiveSource())) {
                    r16.setImmersiveSource(11);
                }
            }
        }
        QLog.d("ShowMediaMethod", 1, "ShowMediaMethod isImmersive " + z16 + ", immersiveSource: " + r16.getImmersiveSource());
        if (z16) {
            try {
                s(r16);
            } catch (Exception e16) {
                QLog.e("ShowMediaMethod", 1, "initStFeed e:" + e16);
            }
            GuildFeedLauncher.y(BaseApplication.getContext(), r16);
        } else {
            GuildFeedLauncher.G(BaseApplication.getContext(), r16);
        }
        q(d17);
        return true;
    }
}
