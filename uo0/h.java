package uo0;

import androidx.annotation.NonNull;
import com.tencent.guild.aio.input.at.quickAt.search.SearchException;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMemberSearchResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.cl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildMemberSearchSourceId;
import java.util.List;
import mqq.app.AppRuntime;
import wh2.ec;

/* compiled from: P */
/* loaded from: classes6.dex */
public class h extends k {

    /* renamed from: c, reason: collision with root package name */
    private final AppRuntime f439330c;

    /* renamed from: d, reason: collision with root package name */
    public final String f439331d;

    /* renamed from: e, reason: collision with root package name */
    public final String f439332e;

    /* renamed from: f, reason: collision with root package name */
    public final String f439333f;

    /* renamed from: g, reason: collision with root package name */
    private List<IGProUserInfo> f439334g;

    public h(@NonNull AppRuntime appRuntime, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        this.f439330c = appRuntime;
        this.f439331d = str;
        this.f439332e = str2;
        this.f439333f = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(int i3, String str, IGProGuildMemberSearchResult iGProGuildMemberSearchResult) {
        if (j()) {
            QLog.d("MemberAndRolesSearch", 1, "searchGuildMembersBySourceId isCancelled");
            return;
        }
        if (i3 != 0) {
            e(new SearchException(i3, str, this));
            return;
        }
        if (iGProGuildMemberSearchResult != null && iGProGuildMemberSearchResult.getMembers() != null) {
            this.f439334g = iGProGuildMemberSearchResult.getMembers();
        } else {
            QLog.e("MemberAndRolesSearch", 1, "searchGuildMembersBySourceId searchResult is null");
        }
        d();
    }

    @Override // uo0.k
    public String f() {
        return this.f439331d + ":" + this.f439332e + ":" + this.f439333f;
    }

    @Override // uo0.k
    public String h() {
        return this.f439333f;
    }

    @Override // uo0.k
    public List<IGProUserInfo> i() {
        return this.f439334g;
    }

    @Override // uo0.k
    public boolean l() {
        return true;
    }

    @Override // uo0.k
    public void m() {
        IGPSService iGPSService = (IGPSService) this.f439330c.getRuntimeService(IGPSService.class, "");
        cl clVar = new cl();
        clVar.p(GProGuildMemberSearchSourceId.CHANNEL_AT_MEMBER.ordinal());
        clVar.l(com.tencent.guild.aio.input.at.utils.g.a(this.f439331d, 0L));
        clVar.j(com.tencent.guild.aio.input.at.utils.g.a(this.f439332e, 0L));
        clVar.k((int) com.tencent.mobileqq.qqguildsdk.util.f.f268548a);
        clVar.m(this.f439333f);
        iGPSService.searchGuildMembersBySourceId(clVar, new ec() { // from class: uo0.g
            @Override // wh2.ec
            public final void a(int i3, String str, IGProGuildMemberSearchResult iGProGuildMemberSearchResult) {
                h.this.p(i3, str, iGProGuildMemberSearchResult);
            }
        });
    }
}
