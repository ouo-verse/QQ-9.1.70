package yz1;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetGuildFriendsRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.bm;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.bz;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00042\u00020\u0001:\u0001\u0007B\u0019\b\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lyz1/d;", "", "", "j", "f", "i", "", "a", "J", "guildId", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "b", "Ljava/lang/ref/WeakReference;", "activityRef", "Landroid/app/Dialog;", "c", "Landroid/app/Dialog;", "loadingDialog", "", "d", "Z", "hasLoadGuildFriends", "e", "cancelChoose", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;J)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Activity> activityRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean hasLoadGuildFriends;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean cancelChoose;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lyz1/d$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "guildId", "", "a", "DELAY_LOADING_TIME_MS", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: yz1.d$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Activity activity, long guildId) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            new d(activity, guildId, null).j();
        }

        Companion() {
        }
    }

    public /* synthetic */ d(Activity activity, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, j3);
    }

    private final void f() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: yz1.b
            @Override // java.lang.Runnable
            public final void run() {
                d.g(d.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.hasLoadGuildFriends) {
            Logger.f235387a.d().i("GuildChooseFriendHelper", 1, "hasLoadGuildFriends");
            return;
        }
        Activity activity = this$0.activityRef.get();
        if (activity != null) {
            Dialog showOnlyLoadingImageDialog = LoadingUtil.showOnlyLoadingImageDialog(activity, 2, true);
            showOnlyLoadingImageDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: yz1.c
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    d.h(d.this, dialogInterface);
                }
            });
            showOnlyLoadingImageDialog.show();
            this$0.loadingDialog = showOnlyLoadingImageDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(d this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().i("GuildChooseFriendHelper", 1, "cancel share");
        this$0.cancelChoose = true;
    }

    private final void i() {
        Dialog dialog;
        Activity activity = this.activityRef.get();
        if (activity != null && !activity.isFinishing()) {
            Dialog dialog2 = this.loadingDialog;
            boolean z16 = false;
            if (dialog2 != null && dialog2.isShowing()) {
                z16 = true;
            }
            if (z16 && (dialog = this.loadingDialog) != null) {
                dialog.dismiss();
            }
        }
        Dialog dialog3 = this.loadingDialog;
        if (dialog3 != null) {
            dialog3.setOnCancelListener(null);
        }
        this.loadingDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        f();
        bm bmVar = new bm();
        bmVar.b(this.guildId);
        ((IGPSService) ch.R0(IGPSService.class)).getFriendsInGuild(bmVar, new bz() { // from class: yz1.a
            @Override // wh2.bz
            public final void a(int i3, String str, IGProGetGuildFriendsRsp iGProGetGuildFriendsRsp) {
                d.k(d.this, i3, str, iGProGetGuildFriendsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(d this$0, int i3, String str, IGProGetGuildFriendsRsp iGProGetGuildFriendsRsp) {
        int collectionSizeOrDefault;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            long j3 = this$0.guildId;
            ArrayList<Long> uinList = iGProGetGuildFriendsRsp.getUinList();
            Intrinsics.checkNotNullExpressionValue(uinList, "rsp.uinList");
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(uinList, ",", null, null, 0, null, null, 62, null);
            Log.d("GuildChooseFriendHelper", "getFriendsInGuild(" + j3 + "): " + i3 + " - " + str + " " + joinToString$default);
        }
        this$0.hasLoadGuildFriends = true;
        this$0.i();
        if (this$0.cancelChoose) {
            return;
        }
        if (i3 != 0) {
            Logger.f235387a.d().w("GuildChooseFriendHelper", 1, "getFriendsInGuild(" + this$0.guildId + "): " + i3 + " - " + str);
        }
        Activity activity = this$0.activityRef.get();
        if (activity != null) {
            g gVar = g.f451616a;
            long j16 = this$0.guildId;
            bg bgVar = bg.f302144a;
            ArrayList<Long> uinList2 = iGProGetGuildFriendsRsp.getUinList();
            Intrinsics.checkNotNullExpressionValue(uinList2, "rsp.uinList");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(uinList2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = uinList2.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf((Long) it.next()));
            }
            g.h(activity, j16, bgVar.n(arrayList), 0, 0, 0, null, 120, null);
        }
    }

    @JvmStatic
    public static final void l(@NotNull Activity activity, long j3) {
        INSTANCE.a(activity, j3);
    }

    d(Activity activity, long j3) {
        this.guildId = j3;
        this.activityRef = new WeakReference<>(activity);
    }
}
