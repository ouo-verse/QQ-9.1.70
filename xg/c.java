package xg;

import NS_MOBILE_FEEDS.cnst.UNIVERSAL_MALL_QUAL;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.FontCacheManager;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.text.TextCellParser;
import com.qzone.reborn.feedx.util.w;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private gf.a f447923a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f447924b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class a implements w.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Reply f447925a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comment f447926b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f447927c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ h f447928d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ i f447929e;

        a(Reply reply, Comment comment, g gVar, h hVar, i iVar) {
            this.f447925a = reply;
            this.f447926b = comment;
            this.f447927c = gVar;
            this.f447928d = hVar;
            this.f447929e = iVar;
        }

        @Override // com.qzone.reborn.feedx.util.w.c
        public void onClick(View view) {
            int id5 = view.getId();
            if (id5 != R.id.mil) {
                switch (id5) {
                    case R.id.n0w /* 1745224968 */:
                        h hVar = this.f447928d;
                        if (hVar != null) {
                            hVar.a();
                            return;
                        }
                        return;
                    case R.id.n0x /* 1745224969 */:
                        c.this.j(view, this.f447926b, this.f447925a);
                        return;
                    case R.id.n0y /* 1745224970 */:
                        c.this.k(this.f447925a, this.f447926b);
                        return;
                    case R.id.n0z /* 1745224971 */:
                        g gVar = this.f447927c;
                        if (gVar != null) {
                            gVar.a();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            i iVar = this.f447929e;
            if (iVar != null) {
                iVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class b implements w.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Reply f447931a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comment f447932b;

        b(Reply reply, Comment comment) {
            this.f447931a = reply;
            this.f447932b = comment;
        }

        @Override // com.qzone.reborn.feedx.util.w.c
        public void onClick(View view) {
            if (view.getId() == R.id.n0y) {
                c.this.k(this.f447931a, this.f447932b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: xg.c$c, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public class C11545c implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f447934a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ClickedComment f447935b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f447936c;

        C11545c(BusinessFeedData businessFeedData, ClickedComment clickedComment, int i3) {
            this.f447934a = businessFeedData;
            this.f447935b = clickedComment;
            this.f447936c = i3;
        }

        @Override // xg.c.g
        public void a() {
            if (c.this.f447923a != null) {
                c.this.f447923a.z1(this.f447934a, this.f447935b, this.f447936c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class d implements i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f447938a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comment f447939b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Reply f447940c;

        d(BusinessFeedData businessFeedData, Comment comment, Reply reply) {
            this.f447938a = businessFeedData;
            this.f447939b = comment;
            this.f447940c = reply;
        }

        @Override // xg.c.i
        public void a() {
            QZoneFeedUtil.v(c.this.f447924b, this.f447938a, this.f447939b, this.f447940c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class e implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f447942a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comment f447943b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Reply f447944c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f447945d;

        e(BusinessFeedData businessFeedData, Comment comment, Reply reply, int i3) {
            this.f447942a = businessFeedData;
            this.f447943b = comment;
            this.f447944c = reply;
            this.f447945d = i3;
        }

        @Override // xg.c.h
        public void a() {
            String str;
            BusinessFeedData businessFeedData;
            ClickReport.q("431", "10", "1", true);
            BusinessFeedData businessFeedData2 = this.f447942a;
            if (businessFeedData2 == null) {
                str = "";
            } else {
                str = businessFeedData2.getFeedCommInfo().ugckey;
            }
            if (!TextUtils.isEmpty(this.f447943b.commentid)) {
                str = str + "_" + this.f447943b.commentid;
            }
            ClickedComment clickedComment = new ClickedComment();
            clickedComment.isComment = true;
            clickedComment.setComment(this.f447943b);
            clickedComment.setReply(null);
            Map<String, String> f16 = c.this.f(this.f447942a, this.f447944c.content);
            Comment comment = this.f447943b;
            if (comment.pokeLikeCount > 0 && !TextUtils.isEmpty(comment.pokeLikeEmotion) && (businessFeedData = this.f447942a) != null) {
                f16.put("cur_likekey", businessFeedData.getFeedCommInfo().curlikekey);
                f16.put("cmt_poke_emoji", this.f447943b.pokeLikeEmotion);
                f16.put("cmt_poke_count", String.valueOf(this.f447943b.pokeLikeCount));
            }
            if (c.this.f447923a == null || this.f447942a == null) {
                return;
            }
            c.this.f447923a.s6(new com.qzone.reborn.feedx.bean.c().o(this.f447944c.content).r(this.f447945d).n(clickedComment).v("").m(str).s(false).t(false).l(this.f447942a.getFeedCommInfo().feedskey).p(f16));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class f implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comment f447947a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f447948b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f447949c;

        f(Comment comment, BusinessFeedData businessFeedData, int i3) {
            this.f447947a = comment;
            this.f447948b = businessFeedData;
            this.f447949c = i3;
        }

        @Override // xg.c.h
        public void a() {
            String str;
            ClickReport.q("431", "10", "1", true);
            if (this.f447947a.comment.endsWith("[em]e10011[/em]")) {
                Comment comment = this.f447947a;
                String str2 = comment.comment;
                comment.comment = str2.substring(0, str2.lastIndexOf("[em]e10011[/em]"));
            }
            Map<String, String> f16 = c.this.f(this.f447948b, this.f447947a.comment);
            if (this.f447948b != null) {
                Comment comment2 = this.f447947a;
                if (comment2.pokeLikeCount > 0 && !TextUtils.isEmpty(comment2.pokeLikeEmotion)) {
                    f16.put("cur_likekey", this.f447948b.getFeedCommInfo().curlikekey);
                    f16.put("cmt_poke_emoji", this.f447947a.pokeLikeEmotion);
                    f16.put("cmt_poke_count", String.valueOf(this.f447947a.pokeLikeCount));
                }
            }
            if (c.this.f447923a != null) {
                String str3 = "";
                com.qzone.reborn.feedx.bean.c v3 = new com.qzone.reborn.feedx.bean.c().o(this.f447947a.comment).r(this.f447949c).v("");
                BusinessFeedData businessFeedData = this.f447948b;
                if (businessFeedData == null) {
                    str = "";
                } else {
                    str = businessFeedData.getFeedCommInfo().ugckey;
                }
                com.qzone.reborn.feedx.bean.c t16 = v3.m(str).s(false).t(false);
                BusinessFeedData businessFeedData2 = this.f447948b;
                if (businessFeedData2 != null) {
                    str3 = businessFeedData2.getFeedCommInfo().feedskey;
                }
                c.this.f447923a.s6(t16.l(str3).p(f16));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface g {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface h {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface i {
        void a();
    }

    public c(Activity activity) {
        this.f447924b = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> f(BusinessFeedData businessFeedData, String str) {
        FontCacheManager.CommentFontInfo b16;
        HashMap hashMap = new HashMap();
        if ((businessFeedData == null || businessFeedData.getFeedCommInfo().appid != 2) && (b16 = FontCacheManager.a().b()) != null) {
            if (!TextUtils.isEmpty(b16.fontUrl)) {
                hashMap.put("diy_font_id", b16.f44975id + "");
                hashMap.put("diy_font_type", b16.fontFormatType + "");
                hashMap.put("diy_font_url", b16.fontUrl);
            }
            if (!TextUtils.isEmpty(b16.superFontJson)) {
                hashMap.put(QZoneHelper.QzoneFeedActionPanelConstants.KEY_SPARKLE_WORD_ID, b16.superFontId + "");
                hashMap.put("sparkle_json", b16.superFontJson);
            }
            if (str != null && str.length() <= 40 && !TextUtils.isEmpty(b16.barrageEffectJson)) {
                hashMap.put(UNIVERSAL_MALL_QUAL.value, b16.barrageEffectId + "");
                hashMap.put("private_barrage_data", b16.barrageEffectJson);
            }
        }
        return hashMap;
    }

    private g g(BusinessFeedData businessFeedData, Comment comment, Reply reply, int i3) {
        ClickedComment clickedComment = new ClickedComment();
        clickedComment.isComment = reply == null;
        clickedComment.setComment(comment);
        clickedComment.setReply(reply);
        if ((reply == null || reply.user.uin != LoginData.getInstance().getUin()) && !((reply == null && comment.user.uin == LoginData.getInstance().getUin()) || businessFeedData.getUser().uin == LoginData.getInstance().getUin())) {
            return null;
        }
        return new C11545c(businessFeedData, clickedComment, i3);
    }

    private h h(BusinessFeedData businessFeedData, Comment comment, Reply reply, int i3) {
        ArrayList<PictureItem> arrayList;
        String str;
        boolean z16 = comment.isPrivate || ((str = comment.displayStr) != null && str.endsWith("[em]e10011[/em]"));
        if (!z16 && reply != null && !TextUtils.isEmpty(reply.content)) {
            User user = comment.user;
            if (user == null || user.uin != LoginData.getInstance().getUin()) {
                return new e(businessFeedData, comment, reply, i3);
            }
        } else if (!z16 && !TextUtils.isEmpty(comment.comment) && ((arrayList = comment.pictureItems) == null || arrayList.size() <= 0)) {
            return new f(comment, businessFeedData, i3);
        }
        return null;
    }

    private i i(BusinessFeedData businessFeedData, Comment comment, Reply reply) {
        boolean z16 = comment.isCanJubao;
        boolean z17 = reply != null && reply.isCanJubao;
        i iVar = null;
        if ((reply != null && reply.user.uin == LoginData.getInstance().getUin()) || ((reply == null && comment.user.uin == LoginData.getInstance().getUin()) || businessFeedData.getUser().uin == LoginData.getInstance().getUin())) {
            if (reply != null && !TextUtils.isEmpty(reply.replyId)) {
                if (!businessFeedData.getLocalInfo().canDelReply && z17) {
                    iVar = l(businessFeedData, comment, reply);
                }
            } else if (!businessFeedData.getLocalInfo().canDelComment && z16) {
                iVar = l(businessFeedData, comment, null);
            }
            if (z16 || z17) {
                iVar = l(businessFeedData, comment, reply);
            }
        }
        return (z16 || z17) ? l(businessFeedData, comment, reply) : iVar;
    }

    private i l(BusinessFeedData businessFeedData, Comment comment, Reply reply) {
        return new d(businessFeedData, comment, reply);
    }

    public void o(gf.a aVar) {
        this.f447923a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(View view, Comment comment, Reply reply) {
        long j3;
        String str;
        if (reply != null) {
            j3 = reply.user.uin;
            str = QZoneFeedUtil.o(reply);
        } else if (QZoneFeedUtil.n(comment) != null) {
            j3 = comment.user.uin;
            str = QZoneFeedUtil.n(comment);
        } else {
            j3 = 0;
            str = null;
        }
        LpReportInfo_pf00064.report(129, 4);
        vo.c.E(view.getContext(), j3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Reply reply, Comment comment) {
        String str = reply != null ? reply.content : null;
        if (TextUtils.isEmpty(str)) {
            str = comment != null ? comment.comment : null;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.qzone.adapter.feedcomponent.i.H().s(TextCellParser.toPlainText(str));
    }

    public void n(View view, Comment comment, Reply reply) {
        if (view != null && comment != null && this.f447924b != null) {
            com.tencent.biz.qqcircle.richframework.widget.menu.c cVar = new com.tencent.biz.qqcircle.richframework.widget.menu.c();
            if (!TextUtils.isEmpty(comment.comment) || (reply != null && !TextUtils.isEmpty(reply.content))) {
                cVar.a(R.id.n0y, HardCodeUtil.qqStr(R.string.rfw));
            }
            w.a().b(view, cVar, new b(reply, comment));
            return;
        }
        QLog.e("QZoneFeedxCommentLongClickProcess", 1, "[onPassiveCommentLongClick]  params error");
    }

    public void m(View view, BusinessFeedData businessFeedData, Comment comment, Reply reply, int i3) {
        if (view != null && businessFeedData != null && comment != null && this.f447924b != null) {
            h h16 = h(businessFeedData, comment, reply, i3);
            g g16 = g(businessFeedData, comment, reply, i3);
            i i16 = i(businessFeedData, comment, reply);
            com.tencent.biz.qqcircle.richframework.widget.menu.c cVar = new com.tencent.biz.qqcircle.richframework.widget.menu.c();
            if (!TextUtils.isEmpty(comment.comment) || (reply != null && !TextUtils.isEmpty(reply.content))) {
                cVar.a(R.id.n0y, HardCodeUtil.qqStr(R.string.rfw));
            }
            if (i16 != null) {
                cVar.a(R.id.mil, HardCodeUtil.qqStr(R.string.f133195g));
            }
            if (g16 != null) {
                cVar.a(R.id.n0z, HardCodeUtil.qqStr(R.string.rfx));
            }
            if (h16 != null) {
                cVar.a(R.id.n0w, HardCodeUtil.qqStr(R.string.rfg));
            }
            cVar.a(R.id.n0x, HardCodeUtil.qqStr(R.string.rfh));
            w.a().b(view, cVar, new a(reply, comment, g16, h16, i16));
            return;
        }
        QLog.e("QZoneFeedxCommentLongClickProcess", 1, "onCommentLongClick  params error");
    }
}
