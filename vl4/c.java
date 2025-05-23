package vl4;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.profile.impl.dialog.picker.PickerSelectItemView;
import com.tencent.timi.game.ui.widget.BaseSlideUpDialog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.VerticalGallery;
import fh4.g;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nr2.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import vl4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00010\u0001*\u0004\b\u0001\u0010\u00032\u00020\u00042\u00020\u0005BM\u0012\u0006\u0010C\u001a\u00020B\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b\u0012\b\u0010#\u001a\u0004\u0018\u00010 \u0012\u0006\u0010&\u001a\u00020\u001c\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\rH\u0016R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u0019R\u0016\u0010*\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u0019R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010)R$\u00105\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00109\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lvl4/c;", "Lvl4/d;", UserInfo.SEX_FEMALE, ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/timi/game/ui/widget/BaseSlideUpDialog;", "Landroid/view/View$OnClickListener;", "", "p0", "initView", "", "secondDataList", "y0", "q0", "Landroid/view/View;", "view", "w0", "s0", "dismiss", "v", NodeProps.ON_CLICK, "T", "Ljava/util/List;", "firstDataList", "", "U", "I", "selectLineNumber", "", "", "V", "Ljava/util/Map;", "reportParamMap", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "W", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "X", "Ljava/lang/String;", "reportPageName", "Y", "firstSelectPosition", "Z", "secondSelectPosition", "", "a0", "confirmClicked", "Lvl4/f;", "b0", "Lvl4/f;", "getPickerSelectResultListener", "()Lvl4/f;", "x0", "(Lvl4/f;)V", "pickerSelectResultListener", "Lvl4/e;", "c0", "Lvl4/e;", "secondAdapter", "Lxl4/a;", "d0", "Lxl4/a;", "arkSelectDialogReport", "Lnr2/o;", "e0", "Lnr2/o;", "binding", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/util/List;ILjava/util/Map;Ltrpc/yes/common/CommonOuterClass$QQUserId;Ljava/lang/String;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c<F extends d<S>, S> extends BaseSlideUpDialog implements View.OnClickListener {

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final List<F> firstDataList;

    /* renamed from: U, reason: from kotlin metadata */
    private final int selectLineNumber;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private Map<String, String> reportParamMap;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private CommonOuterClass$QQUserId qqUserId;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private String reportPageName;

    /* renamed from: Y, reason: from kotlin metadata */
    private int firstSelectPosition;

    /* renamed from: Z, reason: from kotlin metadata */
    private int secondSelectPosition;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean confirmClicked;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f pickerSelectResultListener;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e<S> secondAdapter;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private xl4.a arkSelectDialogReport;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private o binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\f\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"vl4/c$a", "Lcom/tencent/widget/AdapterView$OnItemSelectedListener;", "Lcom/tencent/widget/AdapterView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "view", "", "position", "", "id", "", "onItemSelected", "onNothingSelected", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements AdapterView.OnItemSelectedListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c<F, S> f441841d;

        a(c<F, S> cVar) {
            this.f441841d = cVar;
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(@Nullable AdapterView<?> parent, @Nullable View view, int position, long id5) {
            ((c) this.f441841d).firstSelectPosition = position;
            if (((c) this.f441841d).firstDataList.size() > position) {
                c<F, S> cVar = this.f441841d;
                cVar.y0(((d) ((c) cVar).firstDataList.get(position)).a());
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(@Nullable AdapterView<?> parent) {
            ((c) this.f441841d).firstSelectPosition = -1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\f\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"vl4/c$b", "Lcom/tencent/widget/AdapterView$OnItemSelectedListener;", "Lcom/tencent/widget/AdapterView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "view", "", "position", "", "id", "", "onItemSelected", "onNothingSelected", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements AdapterView.OnItemSelectedListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c<F, S> f441842d;

        b(c<F, S> cVar) {
            this.f441842d = cVar;
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(@Nullable AdapterView<?> parent, @Nullable View view, int position, long id5) {
            ((c) this.f441842d).secondSelectPosition = position;
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(@Nullable AdapterView<?> parent) {
            ((c) this.f441842d).secondSelectPosition = -1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull Context context, @NotNull List<? extends F> firstDataList, int i3, @Nullable Map<String, String> map, @Nullable CommonOuterClass$QQUserId commonOuterClass$QQUserId, @NotNull String reportPageName) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(firstDataList, "firstDataList");
        Intrinsics.checkNotNullParameter(reportPageName, "reportPageName");
        this.firstDataList = firstDataList;
        this.selectLineNumber = i3;
        this.reportParamMap = map;
        this.qqUserId = commonOuterClass$QQUserId;
        this.reportPageName = reportPageName;
        o g16 = o.g(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater)");
        this.binding = g16;
        setContentView(g16.getRoot());
        initView();
        p0();
    }

    private final void initView() {
        RelativeLayout relativeLayout = this.binding.f421100c;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.conentRel");
        g.e(g.c(relativeLayout, Color.parseColor("#F7F7F7")), fh4.b.d(6), fh4.b.d(6), 0.0f, 0.0f);
        e0(this.binding.f421100c);
        this.binding.f421099b.setOnClickListener(this);
        this.binding.f421103f.setOnClickListener(this);
        this.binding.f421101d.setOnClickListener(this);
        q0();
        if (this.selectLineNumber > 1) {
            s0();
            if (this.firstDataList.size() > 0) {
                y0(this.firstDataList.get(0).a());
            }
        }
    }

    private final void p0() {
        Map<String, String> map = this.reportParamMap;
        if (map != null) {
            this.arkSelectDialogReport = new xl4.a(map);
        }
        ql4.b bVar = ql4.b.f429064a;
        RelativeLayout relativeLayout = this.binding.f421104g;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.rootRelative");
        bVar.a(relativeLayout, this.reportPageName);
        xl4.a aVar = this.arkSelectDialogReport;
        if (aVar != null) {
            aVar.b(this.binding.f421099b);
        }
        xl4.a aVar2 = this.arkSelectDialogReport;
        if (aVar2 != null) {
            aVar2.c(this.binding.f421101d);
        }
    }

    private final void q0() {
        Context context = this.G;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        e eVar = new e(context);
        this.binding.f421102e.setAdapter((SpinnerAdapter) eVar);
        this.binding.f421102e.setmMaxRotationAngle(0);
        this.binding.f421102e.setOnSelectViewDataUpdateListener(new VerticalGallery.OnSelectViewDataUpdateListener() { // from class: vl4.a
            @Override // com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener
            public final void onSelectDataUpdate(View view, int i3) {
                c.r0(c.this, view, i3);
            }
        });
        this.binding.f421102e.setOnItemSelectedListener(new a(this));
        eVar.setData(this.firstDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(c this$0, View child, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(child, "child");
        this$0.w0(child);
    }

    private final void s0() {
        Context context = this.G;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        e<S> eVar = new e<>(context);
        this.secondAdapter = eVar;
        this.binding.f421105h.setAdapter((SpinnerAdapter) eVar);
        WheelView wheelView = this.binding.f421105h;
        Intrinsics.checkNotNullExpressionValue(wheelView, "binding.secondWheelView");
        g.o(wheelView, true);
        this.binding.f421105h.setmMaxRotationAngle(0);
        this.binding.f421105h.setOnSelectViewDataUpdateListener(new VerticalGallery.OnSelectViewDataUpdateListener() { // from class: vl4.b
            @Override // com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener
            public final void onSelectDataUpdate(View view, int i3) {
                c.u0(c.this, view, i3);
            }
        });
        this.binding.f421105h.setOnItemSelectedListener(new b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(c this$0, View child, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(child, "child");
        this$0.w0(child);
    }

    private final void w0(View view) {
        if (view instanceof PickerSelectItemView) {
            ((PickerSelectItemView) view).setSelectStyle(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0(List<? extends S> secondDataList) {
        e<S> eVar;
        if (secondDataList != null && (eVar = this.secondAdapter) != null) {
            eVar.setData(secondDataList);
        }
    }

    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.b, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (this.confirmClicked) {
            f fVar = this.pickerSelectResultListener;
            if (fVar != null) {
                fVar.a(this.firstSelectPosition, this.secondSelectPosition);
                return;
            }
            return;
        }
        f fVar2 = this.pickerSelectResultListener;
        if (fVar2 != null) {
            fVar2.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!com.tencent.timi.game.utils.o.a()) {
            int id5 = v3.getId();
            if (id5 == R.id.enf || id5 == R.id.tlc) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                dismiss();
            } else if (id5 == R.id.b7n) {
                this.confirmClicked = true;
                dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void x0(@Nullable f fVar) {
        this.pickerSelectResultListener = fVar;
    }
}
