package xy;

import UserGrowth.stMsgContent;
import UserGrowth.stMsgContentPersonInfo;
import UserGrowth.stNotifyMsg;
import UserGrowth.stSchema;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi.combo.msg.detail.WSMsgDetailFragment;
import com.tencent.biz.pubaccount.weishi.profile.WSProfileFragment;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import h00.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\"\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ/\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lxy/h;", "", "Landroid/content/Context;", "context", "LUserGrowth/stSchema;", ZPlanPublishSource.FROM_SCHEME, "Lxy/h$a;", "jumpListener", "", "c", "Lyy/c;", "data", "", "b", "a", "d", "e", "", "fromScene", "title", "", "subjectId", "f", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f449023a = new h();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lxy/h$a;", "", "", "actionId", "", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public interface a {
        void a(int actionId);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"xy/h$b", "Lxy/h$a;", "", "actionId", "", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ yy.c f449024a;

        b(yy.c cVar) {
            this.f449024a = cVar;
        }

        @Override // xy.h.a
        public void a(int actionId) {
            String e16 = this.f449024a.e();
            Intrinsics.checkNotNullExpressionValue(e16, "data.sopName");
            String str = this.f449024a.a().msgID;
            Intrinsics.checkNotNullExpressionValue(str, "data.msgInfo.msgID");
            String valueOf = String.valueOf(this.f449024a.f());
            stMsgContentPersonInfo stmsgcontentpersoninfo = this.f449024a.a().oper;
            String str2 = stmsgcontentpersoninfo != null ? stmsgcontentpersoninfo.PID : null;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = this.f449024a.a().contentFeedID;
            Intrinsics.checkNotNullExpressionValue(str3, "data.msgInfo.contentFeedID");
            xy.b.d(e16, str, valueOf, str2, actionId, str3, this.f449024a.a().flag, this.f449024a.a().delFlag);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"xy/h$c", "Lh00/d;", "", "d", "c", "a", "b", "e", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c extends h00.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f449025a;

        c(a aVar) {
            this.f449025a = aVar;
        }

        @Override // h00.d, h00.b
        public void a() {
            a aVar = this.f449025a;
            if (aVar != null) {
                aVar.a(1000004);
            }
        }

        @Override // h00.d, h00.b
        public void b() {
            a aVar = this.f449025a;
            if (aVar != null) {
                aVar.a(1000002);
            }
        }

        @Override // h00.d, h00.b
        public void c() {
            a aVar = this.f449025a;
            if (aVar != null) {
                aVar.a(1000007);
            }
        }

        @Override // h00.d, h00.b
        public void d() {
            a aVar = this.f449025a;
            if (aVar != null) {
                aVar.a(1000003);
            }
        }

        @Override // h00.d, h00.b
        public void e() {
            super.e();
            a aVar = this.f449025a;
            if (aVar != null) {
                aVar.a(1000001);
            }
        }
    }

    h() {
    }

    private final boolean b(Context context, yy.c data) {
        stNotifyMsg a16 = data.a();
        if (a16 != null && a16.delFlag == 1) {
            QQToast.makeText(context, 1, R.string.x9c, 0).show();
            return true;
        }
        stNotifyMsg a17 = data.a();
        Integer valueOf = a17 != null ? Integer.valueOf(a17.flag) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            QQToast.makeText(context, 1, R.string.x95, 0).show();
            return true;
        }
        if ((valueOf != null && valueOf.intValue() == 2) || (valueOf != null && valueOf.intValue() == 8)) {
            QQToast.makeText(context, 1, R.string.x9_, 0).show();
            return true;
        }
        if (valueOf != null && valueOf.intValue() == 4) {
            QQToast.makeText(context, 1, R.string.x9a, 0).show();
            return true;
        }
        if (valueOf == null || valueOf.intValue() != 32) {
            return false;
        }
        QQToast.makeText(context, 1, R.string.x9c, 0).show();
        return true;
    }

    public final void a(Context context, yy.c data) {
        stMsgContent stmsgcontent;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        if (bb.E() || b(context, data)) {
            return;
        }
        stNotifyMsg a16 = data.a();
        c(context, (a16 == null || (stmsgcontent = a16.content) == null) ? null : stmsgcontent.schema, new b(data));
    }

    public final void d(Context context, stSchema scheme, a jumpListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (bb.E()) {
            return;
        }
        c(context, scheme, jumpListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(Context context, yy.c data) {
        String str;
        String str2;
        String str3;
        stNotifyMsg a16;
        stMsgContentPersonInfo stmsgcontentpersoninfo;
        Intrinsics.checkNotNullParameter(context, "context");
        if (bb.E()) {
            return;
        }
        String str4 = (data == null || (a16 = data.a()) == null || (stmsgcontentpersoninfo = a16.oper) == null) ? null : stmsgcontentpersoninfo.PID;
        if (str4 != null) {
            String e16 = data.e();
            if (e16 != null) {
                int hashCode = e16.hashCode();
                if (hashCode != -1286505224) {
                    if (hashCode != -1286318897) {
                        if (hashCode == 768159405 && e16.equals("message_section")) {
                            str = "msg_section";
                        }
                    } else if (e16.equals("message_like")) {
                        str = "msg_like";
                    }
                } else if (e16.equals("message_fans")) {
                    str = "msg_fans";
                }
                WSProfileFragment.ri(context, str4, str);
                String e17 = data.e();
                Intrinsics.checkNotNullExpressionValue(e17, "data.sopName");
                stNotifyMsg a17 = data.a();
                str2 = a17 == null ? a17.msgID : null;
                String str5 = "";
                if (str2 != null) {
                    str2 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str2, "data.msgInfo?.msgID ?: \"\"");
                }
                String valueOf = String.valueOf(data.f());
                stNotifyMsg a18 = data.a();
                str3 = a18 != null ? a18.contentFeedID : null;
                if (str3 != null) {
                    Intrinsics.checkNotNullExpressionValue(str3, "data.msgInfo?.contentFeedID ?: \"\"");
                    str5 = str3;
                }
                xy.b.h(e17, str2, valueOf, str4, str5);
            }
            str = "msg";
            WSProfileFragment.ri(context, str4, str);
            String e172 = data.e();
            Intrinsics.checkNotNullExpressionValue(e172, "data.sopName");
            stNotifyMsg a172 = data.a();
            if (a172 == null) {
            }
            String str52 = "";
            if (str2 != null) {
            }
            String valueOf2 = String.valueOf(data.f());
            stNotifyMsg a182 = data.a();
            if (a182 != null) {
            }
            if (str3 != null) {
            }
            xy.b.h(e172, str2, valueOf2, str4, str52);
        }
    }

    public final void f(Context context, String fromScene, String title, Integer subjectId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fromScene, "fromScene");
        Intrinsics.checkNotNullParameter(title, "title");
        if (bb.E() || subjectId == null) {
            return;
        }
        zy.g gVar = new zy.g(context, fromScene);
        gVar.c(title);
        gVar.b(subjectId.intValue());
        WSMsgDetailFragment.INSTANCE.a(gVar);
    }

    private final void c(Context context, stSchema scheme, a jumpListener) {
        if (scheme == null) {
            return;
        }
        new j(context).o(scheme).n(true).m(new c(jumpListener)).h();
    }
}
