package xg;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.reborn.comment.bean.CommentReplyParam;
import com.qzone.reborn.feedx.util.aa;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import cooperation.qzone.api.IActivityLauncherProxy;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Fragment f447918a;

    /* renamed from: b, reason: collision with root package name */
    private final IActivityLauncherProxy f447919b;

    /* renamed from: c, reason: collision with root package name */
    private gf.a f447920c;

    /* renamed from: d, reason: collision with root package name */
    private String f447921d;

    /* renamed from: e, reason: collision with root package name */
    private int f447922e;

    public b(Fragment fragment, IActivityLauncherProxy iActivityLauncherProxy) {
        this.f447918a = fragment;
        this.f447919b = iActivityLauncherProxy;
    }

    public void d(gf.a aVar) {
        this.f447920c = aVar;
    }

    public void e(String str) {
        this.f447921d = str;
    }

    public void f(int i3) {
        this.f447922e = i3;
    }

    public void a(BusinessFeedData businessFeedData, ClickedComment clickedComment, int i3) {
        b(businessFeedData, clickedComment, i3, false);
    }

    public void b(BusinessFeedData businessFeedData, ClickedComment clickedComment, int i3, boolean z16) {
        String str;
        String str2;
        String str3;
        int i16;
        gf.a aVar;
        String str4;
        gf.a aVar2;
        if (businessFeedData == null || this.f447918a == null) {
            return;
        }
        String g16 = aa.g(businessFeedData);
        String str5 = "";
        if (TextUtils.isEmpty(g16) || !businessFeedData.isCommentEmpty()) {
            g16 = "";
        }
        int i17 = businessFeedData.isHideSecretComment() ? -1 : 0;
        if (clickedComment == null) {
            str = "";
            str2 = str;
            str3 = str2;
            i16 = -1;
        } else if (clickedComment.getComment() != null && clickedComment.getComment().user != null) {
            if (clickedComment.getReply() != null) {
                if (clickedComment.getReply().user.uin == LoginData.getInstance().getUin()) {
                    if (!businessFeedData.getLocalInfo().canDelReply || (aVar2 = this.f447920c) == null) {
                        return;
                    }
                    aVar2.z1(businessFeedData, clickedComment, i3);
                    return;
                }
            } else if (clickedComment.getComment().user.uin == LoginData.getInstance().getUin()) {
                if (!businessFeedData.getLocalInfo().canDelComment || (aVar = this.f447920c) == null) {
                    return;
                }
                aVar.z1(businessFeedData, clickedComment, i3);
                return;
            }
            String str6 = clickedComment.getComment().commentid;
            String valueOf = String.valueOf(clickedComment.getComment().user.uin);
            int i18 = clickedComment.getComment().isPrivate ? 1 : -1;
            if (clickedComment.getReply() != null) {
                str5 = clickedComment.getReply().replyId;
                String str7 = l.a(R.string.jy6) + clickedComment.getReply().user.nickName + ":";
                str3 = String.valueOf(clickedComment.getReply().user.uin);
                str4 = str7;
            } else {
                str4 = l.a(R.string.f171637jy1) + clickedComment.getComment().user.nickName + ":";
                str3 = "";
            }
            i16 = 1208;
            g16 = str4;
            str = valueOf;
            i17 = i18;
            str2 = str5;
            str5 = str6;
        } else {
            QZLog.e("QZoneFeedxCommentClickProcess", "comment is null!!");
            return;
        }
        if (TextUtils.isEmpty(g16)) {
            g16 = l.a(R.string.glb);
        }
        if (i16 == -1) {
            i16 = 1207;
        }
        String str8 = businessFeedData.getFeedCommInfo().feedskey;
        if (z16) {
            str8 = str8 + "_YEAR_TODAY";
        }
        ho.i.c().g(cd.c.b(businessFeedData, str5).v(i3).y(i16).g(str8).q(g16).A(i17).B(this.f447922e).h(new CommentReplyParam(str5, str, str2, str3)).p(this.f447921d).getParams(), this.f447918a, businessFeedData);
    }

    public void c(BusinessFeedData businessFeedData, ClickedComment clickedComment, int i3) {
        String str;
        String str2;
        String a16;
        if (businessFeedData == null || this.f447918a == null) {
            return;
        }
        String str3 = "";
        if (clickedComment == null) {
            str = "";
            str2 = str;
        } else if (clickedComment.getComment() != null && clickedComment.getComment().user != null) {
            str = clickedComment.getComment().commentid;
            if (clickedComment.getReply() == null) {
                str2 = "";
            } else {
                str2 = clickedComment.getReply().replyId;
            }
            if (clickedComment.getComment().user != null && !TextUtils.isEmpty(clickedComment.getComment().user.nickName)) {
                str3 = clickedComment.getComment().user.nickName;
            }
            if (clickedComment.getReply() != null && clickedComment.getReply().user != null && !TextUtils.isEmpty(clickedComment.getReply().user.nickName)) {
                str3 = clickedComment.getReply().user.nickName;
            }
        } else {
            QZLog.e("QZoneFeedxCommentClickProcess", "comment is null!!");
            return;
        }
        if (TextUtils.isEmpty(str3) && businessFeedData.getUser() != null && !TextUtils.isEmpty(businessFeedData.getUser().nickName)) {
            str3 = businessFeedData.getUser().nickName;
        }
        if (!TextUtils.isEmpty(str3)) {
            a16 = cd.c.i(false, str3);
        } else {
            a16 = l.a(R.string.glb);
        }
        ho.i.c().o(cd.c.b(businessFeedData, str).v(i3).y(1208).q(a16).j(false).A(c6.a.e(businessFeedData)).h(new CommentReplyParam(str, null, str2, null)).B(this.f447922e).getParams(), this.f447918a, businessFeedData);
    }
}
