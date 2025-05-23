package s54;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.view.View;
import b54.FunctionReportArgs;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.at.InputAtMsgIntent;
import com.tencent.mobileqq.aio.input.at.a;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.runtime.strategy.IStrategyFetcher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureType;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatures;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFilter;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotScene;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import com.tencent.robot.slash.businessapi.ConvertSearchTools;
import com.tencent.robot.slash.businessapi.SearchSessionParams;
import com.tencent.robot.slash.businessapi.c;
import com.tencent.robot.slash.dialog.content.avatarbar.b;
import com.tencent.robot.slash.dialog.content.middle.TroopSlashListContainerVB;
import com.tencent.robot.slash.dialog.content.tip.SlashTipContentUIState;
import h44.OpenRobotProfileCardArgs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import w64.e;
import w64.f;
import w64.i;
import w64.k;
import w64.l;
import w64.m;
import w64.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0004\u0018\u0000 22\u00020\u0001:\u00010B\u0017\u0012\u0006\u0010A\u001a\u00020?\u0012\u0006\u0010C\u001a\u00020\"\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J(\u0010\u000e\u001a\u00020\r2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u0010\u001a\u00020\u000f2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0002J \u0010\u0013\u001a\u00020\u000f2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0007j\b\u0012\u0004\u0012\u00020\u0011`\tH\u0002J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J4\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001f0\u001ej\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001f` 2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010#\u001a\u00020\"H\u0016J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010%\u001a\u00020$H\u0016J\b\u0010)\u001a\u00020'H\u0016J\u0014\u0010,\u001a\u0004\u0018\u00010+2\b\u0010*\u001a\u0004\u0018\u00010\u001fH\u0016J\u001c\u0010.\u001a\u0004\u0018\u00010\r2\b\u0010-\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u00100\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u00102\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\"H\u0016J\u0010\u00103\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\"H\u0016J\u0010\u00106\u001a\u00020\u000f2\u0006\u00105\u001a\u000204H\u0016J\u0010\u00107\u001a\u00020\u000f2\u0006\u00105\u001a\u000204H\u0016J \u0010;\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u00108\u001a\u00020\u00162\u0006\u0010:\u001a\u000209H\u0016J\u0018\u0010>\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u000bH\u0016R\u0014\u0010A\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010@R\u0014\u0010C\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006J"}, d2 = {"Ls54/a;", "Lcom/tencent/robot/slash/businessapi/c;", "Lw64/m;", "r", "s54/a$c", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ls54/a$c;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatures;", "Lkotlin/collections/ArrayList;", "robotFeaturesList", "", "keyword", "Lcom/tencent/robot/slash/businessapi/a;", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Lb74/a;", "functionItemDataList", "p", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "robotInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "commandInfo", "u", "serviceInfo", "v", "w", "troopUin", "troopName", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "t", "Landroid/view/View;", "l", "Lcom/tencent/mvi/api/runtime/b;", "mviContext", "Lw64/n;", "Lu54/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "args", "Lcom/tencent/robot/slash/businessapi/d;", "k", "searchResponse", "j", "itemData", "a", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "d", "f", "Lb54/a;", "impArgs", "g", "e", "functionInfo", "", "functionType", "i", "robotUin", "robotTinyId", "b", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Landroid/view/View;", "mAnchorView", "Lm64/b;", "c", "Lm64/b;", "mStorageHelper", "<init>", "(Lcom/tencent/aio/api/runtime/a;Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements com.tencent.robot.slash.businessapi.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mAnchorView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final m64.b mStorageHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0096\u0001J\t\u0010\n\u001a\u00020\tH\u0096\u0001J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0096\u0001J\b\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u000f"}, d2 = {"s54/a$b", "Lw64/n;", "Lu54/c;", "Lw64/d;", "f", "Lw64/f;", "c", "Lw64/k;", "a", "Lw64/i;", "d", "Lw64/l;", "e", "Lw64/m;", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements n<u54.c> {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ u54.a f433360a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f433361b;

        b(com.tencent.mvi.api.runtime.b bVar, a aVar) {
            this.f433361b = aVar;
            this.f433360a = new u54.a(bVar, aVar);
        }

        @Override // w64.n
        @NotNull
        public k<u54.c> a() {
            return this.f433360a.a();
        }

        @Override // w64.n
        @NotNull
        public m b() {
            return this.f433361b.r();
        }

        @Override // w64.n
        @NotNull
        public f c() {
            return this.f433360a.c();
        }

        @Override // w64.n
        @NotNull
        public i d() {
            return this.f433360a.d();
        }

        @Override // w64.n
        @NotNull
        public l<u54.c> e() {
            return this.f433360a.e();
        }

        @Override // w64.n
        @NotNull
        public w64.d<u54.c> f() {
            return this.f433360a.f();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"s54/a$c", "Lcom/tencent/robot/slash/dialog/content/middle/a;", "Lcom/tencent/robot/slash/dialog/content/middle/TroopSlashListContainerVB;", "c", "Lh64/d;", "d", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements com.tencent.robot.slash.dialog.content.middle.a {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001J\b\u0010\u0007\u001a\u00020\u0006H\u0016J*\u0010\u000b\u001a\u00020\n2 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"s54/a$c$a", "Lnl3/a;", "Lh64/a;", "Lcom/tencent/robot/slash/dialog/content/tip/SlashTipContentUIState;", "Lw64/e;", "Lu54/c;", "Lt54/a;", "c", "Lcom/tencent/mvi/mvvm/BaseVM;", "mUIModel", "", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: s54.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C11206a implements nl3.a<h64.a, SlashTipContentUIState, e<u54.c>> {
            C11206a() {
            }

            @Override // nl3.a
            public void b(@Nullable BaseVM<h64.a, SlashTipContentUIState, e<u54.c>> mUIModel) {
                if (mUIModel != null) {
                    mUIModel.create();
                }
            }

            @Override // nl3.a
            @NotNull
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public t54.a a() {
                return new t54.a();
            }
        }

        c() {
        }

        @Override // com.tencent.robot.slash.dialog.content.middle.a
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public TroopSlashListContainerVB a() {
            return new TroopSlashListContainerVB();
        }

        @Override // com.tencent.robot.slash.dialog.content.middle.a
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public h64.d b() {
            h64.d dVar = new h64.d();
            dVar.setMVmIVMProvider(new C11206a());
            return dVar;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"s54/a$d", "Lw64/m;", "Lcom/tencent/mvi/runtime/strategy/b;", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d implements m {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\u0000\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"s54/a$d$a", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lcom/tencent/robot/slash/dialog/content/middle/a;", "s54/a$c", "c", "()Ls54/a$c;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: s54.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C11207a extends IStrategyFetcher<com.tencent.robot.slash.dialog.content.middle.a> {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f433363b;

            C11207a(a aVar) {
                this.f433363b = aVar;
            }

            @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
            @NotNull
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public c getF447332b() {
                return this.f433363b.q();
            }
        }

        d() {
        }

        @Override // w64.m
        @NotNull
        public com.tencent.mvi.runtime.strategy.b a() {
            k64.d dVar = new k64.d();
            dVar.c(com.tencent.robot.slash.dialog.content.middle.a.class, new C11207a(a.this));
            return dVar;
        }
    }

    public a(@NotNull com.tencent.aio.api.runtime.a mAIOContext, @NotNull View mAnchorView) {
        Intrinsics.checkNotNullParameter(mAIOContext, "mAIOContext");
        Intrinsics.checkNotNullParameter(mAnchorView, "mAnchorView");
        this.mAIOContext = mAIOContext;
        this.mAnchorView = mAnchorView;
        this.mStorageHelper = new m64.b();
    }

    private final void p(ArrayList<b74.a> functionItemDataList) {
        List<m64.a> a16 = this.mStorageHelper.a(this.mAIOContext.g().r().c().j());
        if (a16.isEmpty()) {
            return;
        }
        ConvertSearchTools.f368422a.a(a16, functionItemDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c q() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final m r() {
        return new d();
    }

    private final com.tencent.robot.slash.businessapi.a s(ArrayList<CommonBotFeatures> robotFeaturesList, String keyword) {
        x(robotFeaturesList);
        ConvertSearchTools convertSearchTools = ConvertSearchTools.f368422a;
        ArrayList<b74.a> f16 = convertSearchTools.f(robotFeaturesList, keyword);
        p(f16);
        List<b.UIModelData> b16 = convertSearchTools.b(f16);
        CollectionsKt__MutableCollectionsKt.removeFirstOrNull(f16);
        return new com.tencent.robot.slash.businessapi.a(f16, b16, 0, 4, null);
    }

    private final HashMap<String, Object> t(String troopUin, String troopName) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.PG_ID, "pg_sgrp_robot_slash_halfscreen");
        hashMap.put("group_id", troopUin);
        hashMap.put("group_name", troopName);
        hashMap.put("invoke_scene", 2);
        return hashMap;
    }

    private final void u(CommonBotInfo robotInfo, CommonBotFeatureInfo commandInfo) {
        a.C7251a c7251a;
        CharSequence a16;
        QLog.i("TroopSlashBusinessDelegate", 1, "handleCommandItemClick robot uin = " + robotInfo.uin + " command name = " + commandInfo.name);
        this.mStorageHelper.e(this.mAIOContext.g().r().c().j(), robotInfo, commandInfo, 1);
        if (h34.a.f(robotInfo)) {
            Context context = this.mAIOContext.c().getContext();
            if (context == null) {
                return;
            }
            QQToast.makeText(context, context.getString(R.string.f222486dn), 1).show();
            return;
        }
        j e16 = this.mAIOContext.e();
        String str = robotInfo.uid;
        Intrinsics.checkNotNullExpressionValue(str, "robotInfo.uid");
        String valueOf = String.valueOf(robotInfo.uin);
        String str2 = robotInfo.name;
        Intrinsics.checkNotNullExpressionValue(str2, "robotInfo.name");
        com.tencent.mvi.base.route.k k3 = e16.k(new InputAtMsgIntent.CreateAtSpan(str, valueOf, str2, true));
        if (k3 instanceof a.C7251a) {
            c7251a = (a.C7251a) k3;
        } else {
            c7251a = null;
        }
        if (c7251a != null && (a16 = c7251a.a()) != null) {
            SpannableStringBuilder append = new SpannableStringBuilder(a16).append((CharSequence) (commandInfo.name + " "));
            Intrinsics.checkNotNullExpressionValue(append, "SpannableStringBuilder(a\u2026mmandInfo.name.plus(\" \"))");
            SpannedString valueOf2 = SpannedString.valueOf(append);
            Intrinsics.checkNotNullExpressionValue(valueOf2, "SpannedString.valueOf(this)");
            e16.h(new InputEditTextMsgIntent.SetTextToEditText(valueOf2, true));
        }
    }

    private final void v(CommonBotInfo robotInfo, CommonBotFeatureInfo serviceInfo) {
        QLog.i("TroopSlashBusinessDelegate", 1, "handleServiceItemClick robot uin = " + robotInfo.uin + " service name = " + serviceInfo.name);
        this.mStorageHelper.e(this.mAIOContext.g().r().c().j(), robotInfo, serviceInfo, 2);
        Context context = this.mAIOContext.c().getContext();
        if (context == null) {
            return;
        }
        if (h34.a.f(robotInfo)) {
            QQToast.makeText(context, context.getString(R.string.f222486dn), 1).show();
            return;
        }
        int i3 = serviceInfo.type;
        if (i3 == CommonBotFeatureType.H5.ordinal()) {
            QLog.i("TroopSlashBusinessDelegate", 1, "openFunctionUrl url = " + serviceInfo.url);
            String str = serviceInfo.url;
            Intrinsics.checkNotNullExpressionValue(str, "serviceInfo.url");
            n64.b.c(context, str);
            return;
        }
        if (i3 == CommonBotFeatureType.MINIAPP.ordinal()) {
            QLog.i("TroopSlashBusinessDelegate", 1, "openFunctionMiniApp url = " + serviceInfo.url);
            String str2 = serviceInfo.url;
            Intrinsics.checkNotNullExpressionValue(str2, "serviceInfo.url");
            n64.b.b(context, str2, 0, 4, null);
            return;
        }
        QLog.i("TroopSlashBusinessDelegate", 1, "handleServiceItemClick type error! type = " + serviceInfo.type);
    }

    private final void w(CommonBotInfo robotInfo) {
        QLog.i("TroopSlashBusinessDelegate", 1, "handleSlashTitleClick robot uin = " + robotInfo.uin);
        Context context = this.mAIOContext.c().getContext();
        if (context == null) {
            return;
        }
        ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).openRobotProfileCard(new OpenRobotProfileCardArgs(context, String.valueOf(robotInfo.uin), this.mAIOContext.g().r().c().j(), 3, 0, null, 48, null));
    }

    private final void x(ArrayList<CommonBotFeatures> robotFeaturesList) {
        if (robotFeaturesList.isEmpty()) {
            return;
        }
        List<String> b16 = this.mStorageHelper.b(this.mAIOContext.g().r().c().j());
        if (b16.isEmpty()) {
            return;
        }
        ConvertSearchTools.f368422a.m(b16, robotFeaturesList);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void a(@NotNull b74.a itemData, @Nullable String keyword) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        if (itemData instanceof x54.b) {
            x54.b bVar = (x54.b) itemData;
            u(bVar.getRobotInfo(), bVar.getCommandInfo());
            return;
        }
        if (itemData instanceof z54.b) {
            z54.b bVar2 = (z54.b) itemData;
            u(bVar2.getRobotInfo(), bVar2.getCommandInfo());
            return;
        }
        if (itemData instanceof d64.b) {
            d64.b bVar3 = (d64.b) itemData;
            v(bVar3.getRobotInfo(), bVar3.getServiceInfo());
        } else if (itemData instanceof a64.b) {
            a64.b bVar4 = (a64.b) itemData;
            v(bVar4.getRobotInfo(), bVar4.getServiceInfo());
        } else if (itemData instanceof e64.b) {
            w(((e64.b) itemData).getRobotInfo());
        }
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void b(@NotNull String robotUin, @NotNull String robotTinyId) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(robotTinyId, "robotTinyId");
        Context context = this.mAIOContext.c().getContext();
        if (context == null) {
            return;
        }
        ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).openRobotProfileCard(new OpenRobotProfileCardArgs(context, robotUin, this.mAIOContext.g().r().c().j(), 3, 0, null, 48, null));
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void c() {
        c.a.c(this);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void d(@NotNull View rootView) {
        IRuntimeService iRuntimeService;
        TroopInfo findTroopInfo;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        String j3 = this.mAIOContext.g().r().c().j();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = "";
        String str2 = null;
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(ITroopInfoService.class, "");
        } else {
            iRuntimeService = null;
        }
        ITroopInfoService iTroopInfoService = (ITroopInfoService) iRuntimeService;
        if (iTroopInfoService != null && (findTroopInfo = iTroopInfoService.findTroopInfo(j3)) != null) {
            str2 = findTroopInfo.troopname;
        }
        if (str2 != null) {
            str = str2;
        }
        HashMap<String, Object> t16 = t(j3, str);
        VideoReport.setPageId(rootView, "pg_sgrp_robot_slash_halfscreen");
        VideoReport.setPageParams(rootView, new PageParams(t16));
        VideoReport.reportEvent("dt_pgin", rootView, t16);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void e(@NotNull FunctionReportArgs impArgs) {
        Intrinsics.checkNotNullParameter(impArgs, "impArgs");
        if (impArgs.getFunctionType() == 1) {
            b54.c.f27957a.a(impArgs);
        } else if (impArgs.getFunctionType() == 2) {
            b54.c.f27957a.c(impArgs);
        }
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void f(@NotNull View rootView) {
        IRuntimeService iRuntimeService;
        TroopInfo findTroopInfo;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        String j3 = this.mAIOContext.g().r().c().j();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = "";
        String str2 = null;
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(ITroopInfoService.class, "");
        } else {
            iRuntimeService = null;
        }
        ITroopInfoService iTroopInfoService = (ITroopInfoService) iRuntimeService;
        if (iTroopInfoService != null && (findTroopInfo = iTroopInfoService.findTroopInfo(j3)) != null) {
            str2 = findTroopInfo.troopname;
        }
        if (str2 != null) {
            str = str2;
        }
        HashMap<String, Object> t16 = t(j3, str);
        VideoReport.setPageId(rootView, "pg_sgrp_robot_slash_halfscreen");
        VideoReport.setPageParams(rootView, new PageParams(t16));
        VideoReport.reportEvent("dt_pgout", rootView, t16);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void g(@NotNull FunctionReportArgs impArgs) {
        Intrinsics.checkNotNullParameter(impArgs, "impArgs");
        if (impArgs.getFunctionType() == 1) {
            b54.c.f27957a.b(impArgs);
        } else if (impArgs.getFunctionType() == 2) {
            b54.c.f27957a.d(impArgs);
        }
    }

    @Override // com.tencent.robot.slash.businessapi.b
    @NotNull
    public u54.c h() {
        AIOContact c16 = this.mAIOContext.g().r().c();
        return new u54.c(c16.j(), c16.e());
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public boolean hideKeyboard() {
        return c.a.b(this);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void i(@NotNull CommonBotInfo robotInfo, @NotNull CommonBotFeatureInfo functionInfo, int functionType) {
        Intrinsics.checkNotNullParameter(robotInfo, "robotInfo");
        Intrinsics.checkNotNullParameter(functionInfo, "functionInfo");
        this.mStorageHelper.e(this.mAIOContext.g().r().c().j(), robotInfo, functionInfo, functionType);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    @Nullable
    public com.tencent.robot.slash.businessapi.a j(@Nullable Object searchResponse, @NotNull String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        if (searchResponse instanceof List) {
            ArrayList<CommonBotFeatures> arrayList = new ArrayList<>();
            for (Object obj : (Iterable) searchResponse) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatures");
                arrayList.add((CommonBotFeatures) obj);
            }
            return s(arrayList, keyword);
        }
        return null;
    }

    @Override // com.tencent.robot.slash.businessapi.c
    @Nullable
    public SearchSessionParams k(@Nullable Object args) {
        String j3 = this.mAIOContext.g().r().c().j();
        int e16 = this.mAIOContext.g().r().c().e();
        return new SearchSessionParams(new Contact(e16, j3, ""), new ArrayList(), new ArrayList(), CommonBotScene.GROUP, CommonBotFilter.KNONE, j3 + "_" + e16);
    }

    @Override // com.tencent.robot.slash.businessapi.b
    @NotNull
    /* renamed from: l, reason: from getter */
    public View getMAnchorView() {
        return this.mAnchorView;
    }

    @Override // com.tencent.robot.slash.businessapi.c
    @NotNull
    public n<u54.c> m(@NotNull com.tencent.mvi.api.runtime.b mviContext) {
        Intrinsics.checkNotNullParameter(mviContext, "mviContext");
        return new b(mviContext, this);
    }
}
