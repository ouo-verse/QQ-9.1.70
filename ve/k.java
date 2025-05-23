package ve;

import com.qzone.reborn.feedx.part.QZoneFeedxHotBannerPart;
import com.qzone.reborn.feedx.part.QZoneFeedxRedirectH5Part;
import com.qzone.reborn.feedx.part.QZoneFeedxUndealCountPart;
import com.qzone.reborn.feedx.part.QZoneFeedxVisitNotifyTopBannerPart;
import com.qzone.reborn.feedx.part.QZoneFriendFeedTitlePart;
import com.qzone.reborn.feedx.part.aa;
import com.qzone.reborn.feedx.part.ab;
import com.qzone.reborn.feedx.part.al;
import com.qzone.reborn.feedx.part.am;
import com.qzone.reborn.feedx.part.an;
import com.qzone.reborn.feedx.part.ao;
import com.qzone.reborn.feedx.part.at;
import com.qzone.reborn.feedx.part.bb;
import com.qzone.reborn.feedx.part.bd;
import com.qzone.reborn.feedx.part.bg;
import com.qzone.reborn.feedx.part.bl;
import com.qzone.reborn.feedx.part.bu;
import com.qzone.reborn.feedx.part.bw;
import com.qzone.reborn.feedx.part.ca;
import com.qzone.reborn.feedx.part.cb;
import com.qzone.reborn.feedx.part.cc;
import com.qzone.reborn.feedx.part.t;
import com.qzone.reborn.feedx.part.u;
import com.qzone.reborn.part.plus.QZoneFeedXFloatPlusBubblePart;
import com.qzone.reborn.part.plusnew.QzoneNewPlusMenuContainerPart;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class k extends j {

    /* renamed from: a, reason: collision with root package name */
    private QZoneFriendFeedTitlePart f441494a;

    private List<Part> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new QZoneFeedxHotBannerPart());
        arrayList.add(new bl());
        arrayList.add(new at());
        return arrayList;
    }

    private List<Part> e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new bu());
        arrayList.add(new al());
        arrayList.add(new an());
        arrayList.add(new u());
        arrayList.add(new QZoneFeedxVisitNotifyTopBannerPart());
        arrayList.add(new ao());
        if (bb.INSTANCE.a()) {
            arrayList.add(new bb());
        }
        return arrayList;
    }

    @Override // ve.j
    public List<Part> b(i iVar) {
        ArrayList arrayList = new ArrayList();
        QZoneFriendFeedTitlePart qZoneFriendFeedTitlePart = new QZoneFriendFeedTitlePart(true);
        this.f441494a = qZoneFriendFeedTitlePart;
        arrayList.add(qZoneFriendFeedTitlePart);
        arrayList.add(new aa());
        arrayList.add(new bg());
        arrayList.add(new QzoneNewPlusMenuContainerPart(iVar.c(), gdt_analysis_event.EVENT_MOTIVE_CLOSE));
        arrayList.add(new QZoneFeedxRedirectH5Part());
        arrayList.add(new bw());
        arrayList.add(new QZoneFeedxUndealCountPart());
        arrayList.add(new t());
        arrayList.add(new bd());
        arrayList.addAll(e());
        arrayList.addAll(d());
        arrayList.add(new am());
        arrayList.add(new ca());
        arrayList.add(new cb());
        arrayList.add(new ab());
        arrayList.add(new com.qzone.reborn.part.plus.d(iVar, gdt_analysis_event.EVENT_MOTIVE_CLOSE));
        arrayList.add(new QZoneFeedXFloatPlusBubblePart());
        arrayList.add(new cc("page_launch_friend_feed"));
        arrayList.add(new com.qzone.reborn.feedx.part.a());
        arrayList.add(new com.qzone.reborn.feedx.part.n());
        return arrayList;
    }
}
