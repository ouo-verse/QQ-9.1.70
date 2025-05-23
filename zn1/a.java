package zn1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.feed.usecases.GuildFeedArkShareInfo;
import com.tencent.mobileqq.guild.share.GuildShareWrapper;
import com.tencent.mobileqq.guild.share.ShareInfoResult;
import com.tencent.mobileqq.guild.share.t;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qqguildsdk.data.genc.ey;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.group_pro_proto.channel_share.ChannelShareRequest$FeedParam;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final GuildFeedArkShareInfo f452789a;

    /* renamed from: b, reason: collision with root package name */
    private final d f452790b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: zn1.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C11701a implements t {
        C11701a() {
        }

        @Override // com.tencent.mobileqq.guild.share.t
        public void a(ShareInfoResult shareInfoResult) {
            QLog.d("FetchFeedShareInfoUseCase", 1, "onFetchGuildShareUrl,  result=", shareInfoResult);
            e eVar = new e(shareInfoResult.getShareUrl(), shareInfoResult.getShareInfo(), shareInfoResult.getLongShareUrl());
            if (!((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).checkSecurityValid(shareInfoResult.getSecResult())) {
                a.this.c(ri1.a.c(-200, "\u5b89\u5168\u9519\u8bef", shareInfoResult.getSecResult()), eVar);
            } else {
                a.this.c(ri1.a.b(shareInfoResult.getResult(), shareInfoResult.getErrMsg()), eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b extends ey {
        b() {
            c("needOpenWeb");
            d(a.this.f452789a.r());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class c extends ey {
        c() {
            c("funclist");
            d(a.this.f452789a.o());
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface d {
        void a(@NonNull ri1.a aVar, @Nullable e eVar);
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final String f452794a;

        /* renamed from: b, reason: collision with root package name */
        public final String f452795b;

        /* renamed from: c, reason: collision with root package name */
        public final String f452796c;

        public e(String str, String str2, String str3) {
            this.f452794a = str;
            this.f452795b = str2;
            this.f452796c = str3;
        }
    }

    public a(@NonNull GuildFeedArkShareInfo guildFeedArkShareInfo, @NonNull d dVar) {
        this.f452789a = guildFeedArkShareInfo;
        this.f452790b = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@NonNull ri1.a aVar, @NonNull e eVar) {
        if (aVar.f431477a != 0) {
            QLog.w("FetchFeedShareInfoUseCase", 1, String.format("onFetchGuildShareUrl,  error=%s, result=%s", aVar, eVar));
        } else if (QLog.isColorLevel()) {
            QLog.d("FetchFeedShareInfoUseCase", 2, String.format("onFetchGuildShareUrl,  error=%s, result=%s", aVar, eVar));
        }
        this.f452790b.a(aVar, eVar);
    }

    public static void e(@NonNull GuildFeedArkShareInfo guildFeedArkShareInfo, d dVar) {
        new a(guildFeedArkShareInfo, dVar).d();
    }

    public void d() {
        ChannelShareRequest$FeedParam channelShareRequest$FeedParam = new ChannelShareRequest$FeedParam();
        channelShareRequest$FeedParam.feed_id.set(this.f452789a.n());
        channelShareRequest$FeedParam.create_time.set(this.f452789a.m());
        channelShareRequest$FeedParam.poster_tiny_id.set(this.f452789a.t());
        C11701a c11701a = new C11701a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b());
        if (this.f452789a.o() != null && !this.f452789a.o().isEmpty()) {
            arrayList.add(new c());
        }
        GuildShareWrapper.e(this.f452789a.p(), this.f452789a.k(), 2, channelShareRequest$FeedParam.toByteArray(), arrayList, c11701a);
    }
}
