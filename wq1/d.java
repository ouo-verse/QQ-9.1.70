package wq1;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.main.announcement.detail.aio.InputState;
import com.tencent.mobileqq.guild.main.announcement.detail.aio.b;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fH\u0016J&\u0010\u0012\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0010\u0012\u0006\b\u0001\u0012\u00020\u00110\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0003H\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lwq1/d;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "", "k1", "j1", "f1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "e1", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "state", "i1", "Lvp1/d;", "d", "Lvp1/d;", "binding", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d extends com.tencent.aio.base.mvvm.a<at.a, InputUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private vp1.d binding;

    private final void f1() {
        String string = getContext().getString(R.string.f152881al);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026_remove_announce_confirm)");
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 0, null, string, null, null);
        createCustomDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: wq1.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                d.g1(dialogInterface, i3);
            }
        });
        createCustomDialog.setPositiveButton(R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: wq1.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                d.h1(d.this, dialogInterface, i3);
            }
        });
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final Context getContext() {
        vp1.d dVar = this.binding;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dVar = null;
        }
        Context context = dVar.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        return context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(d this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            QQToast.makeText(this$0.getContext(), 1, this$0.getContext().getString(R.string.f153151bb), 0).show();
        } else {
            this$0.sendIntent(b.a.f227090d);
            dialogInterface.dismiss();
        }
    }

    private final void j1() {
        vp1.d dVar = this.binding;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dVar = null;
        }
        RelativeLayout relativeLayout = dVar.f442853b;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementId(relativeLayout, "em_remove_main_post");
        VideoReport.setElementExposePolicy(relativeLayout, exposurePolicy);
        VideoReport.setElementClickPolicy(relativeLayout, clickPolicy);
    }

    private final void k1() {
        vp1.d dVar = this.binding;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dVar = null;
        }
        dVar.f442853b.setOnClickListener(new View.OnClickListener() { // from class: wq1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.l1(d.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoReport.reportEvent("clck", view, null);
        this$0.f1();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<at.a, InputUIState> getViewModel() {
        return new com.tencent.mobileqq.guild.main.announcement.detail.aio.viewmodel.a();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        int i3;
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof InputState.AnnouncementCanceled) {
            Context mContext = getMContext();
            Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type android.app.Activity");
            Activity activity = (Activity) mContext;
            if (!activity.isFinishing()) {
                activity.onBackPressed();
                return;
            }
            return;
        }
        if (state instanceof InputState.BottomUiState) {
            vp1.d dVar = this.binding;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dVar = null;
            }
            RelativeLayout relativeLayout = dVar.f442853b;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.guildRlTopMsgDelete");
            if (((InputState.BottomUiState) state).getCanRemove()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            relativeLayout.setVisibility(i3);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new xs3.b(hostView));
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        vp1.d g16 = vp1.d.g(LayoutInflater.from(createViewParams.a()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, createViewParams.parent, false)");
        this.binding = g16;
        k1();
        j1();
        vp1.d dVar = this.binding;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dVar = null;
        }
        LinearLayout root = dVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }
}
