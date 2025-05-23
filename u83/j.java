package u83;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.newalbum.debug.panel.WinkNewAlbumDebugBaseModel;
import com.tencent.mobileqq.wink.newalbum.debug.panel.WinkNewAlbumDebugPanelViewModel;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0014\u0010\u0010\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lu83/j;", "Lp53/b;", "Lu83/k;", "", "position", "", "N9", "I9", "G9", "K9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "Lcom/tencent/mobileqq/wink/newalbum/debug/panel/WinkNewAlbumDebugBaseModel;", "data", "refresh", "onItemClick", "onItemLongClick", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/widget/Button;", "e", "Landroid/widget/Button;", "buttonView", "f", "schemaButtonView", "Lu83/b;", tl.h.F, "Lu83/b;", "adapter", "Lcom/tencent/mobileqq/wink/newalbum/debug/panel/WinkNewAlbumDebugPanelViewModel;", "i", "Lcom/tencent/mobileqq/wink/newalbum/debug/panel/WinkNewAlbumDebugPanelViewModel;", "viewModel", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "selectedItem", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "selectedModelList", "", "D", "Ljava/lang/String;", QZoneDTLoginReporter.SCHEMA, "<init>", "()V", "E", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class j extends p53.b implements k {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<WinkNewAlbumDebugBaseModel> selectedModelList;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String schema;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Button buttonView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Button schemaButtonView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b adapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WinkNewAlbumDebugPanelViewModel viewModel = new WinkNewAlbumDebugPanelViewModel();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int selectedItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lu83/j$a;", "", "", "selectType", "", "a", "ALBUM_SEARCHED_PHOTO", "I", "ALBUM_SHOWN_PHOTO", "SELECTED_COLLECTED_PHOTO", "SELECTED_SIMILARITY_SEARCHED_PHOTO", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: u83.j$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a(int selectType) {
            if (selectType == 0) {
                return "\u5f71\u96c6\u5185\u56fe\u7247";
            }
            if (selectType == 1) {
                return "\u672c\u8f6e\u641c\u7d22\u56fe\u7247";
            }
            if (selectType == 2) {
                return "\u76f8\u4f3c\u5ea6\u56fe\u7247";
            }
            if (selectType == 3) {
                return "\u672c\u8f6e\u805a\u7c7b\u56fe\u7247";
            }
            return "\u672a\u77e5\u64cd\u4f5c";
        }

        Companion() {
        }
    }

    public j() {
        List<WinkNewAlbumDebugBaseModel> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.selectedModelList = emptyList;
        this.schema = "mqqapi://qcircle/openqqpublish?&target=16&memory_album_id=memory_life_blandness8955df24033226b2e137e36a47e167e9&memory_album_title=%E6%8D%95%E6%8D%89%E7%94%9F%E6%B4%BB%E7%9A%84%E6%B8%A9%E6%9F%94";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(j this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void G9(int position) {
        int i3 = this.selectedItem;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        List<WinkNewAlbumDebugBaseModel> b16 = a.INSTANCE.b(this.viewModel.getStoryID(), this.viewModel.getCurrentLoop(), this.viewModel.a());
                        this.selectedModelList = b16;
                        refresh(b16);
                        return;
                    }
                    return;
                }
                List<WinkNewAlbumDebugBaseModel> e16 = a.INSTANCE.e(this.selectedModelList.get(position), this.viewModel.a());
                this.selectedModelList = e16;
                refresh(e16);
                return;
            }
            List<WinkNewAlbumDebugBaseModel> a16 = a.INSTANCE.a(this.viewModel.a());
            this.selectedModelList = a16;
            refresh(a16);
            return;
        }
        List<WinkNewAlbumDebugBaseModel> d16 = a.INSTANCE.d(this.viewModel.a());
        this.selectedModelList = d16;
        refresh(d16);
    }

    static /* synthetic */ void H9(j jVar, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        jVar.G9(i3);
    }

    private final void I9(int position) {
        String str;
        String str2;
        if (position >= this.selectedModelList.size()) {
            QQToast.makeText(getContext(), "select position: " + position + " is out of size: " + this.selectedModelList.size(), 0).show();
        }
        WinkNewAlbumDebugBaseModel winkNewAlbumDebugBaseModel = this.selectedModelList.get(position);
        float score = winkNewAlbumDebugBaseModel.getScore();
        String photoID = winkNewAlbumDebugBaseModel.getPhotoID();
        String photoPath = winkNewAlbumDebugBaseModel.getPhotoPath();
        int mediaType = winkNewAlbumDebugBaseModel.getMediaType();
        if (winkNewAlbumDebugBaseModel.getIsShown()) {
            str2 = "\u5c55\u793a\u5728\u5f71\u96c6\n";
        } else {
            if (winkNewAlbumDebugBaseModel.getIsTextShift()) {
                str = "\u6587\u672c\u76f8\u4f3c\u5ea6\u4e0d\u591f\u672a\u5165\u5e93\n";
            } else {
                str = "";
            }
            str2 = str;
        }
        String str3 = "\u6587\u672c\u76f8\u4f3c\u5ea6: " + score + "\n\u5a92\u4f53ID: " + photoID + " \n\u5a92\u4f53\u5730\u5740: " + photoPath + "\n\u5a92\u4f53\u7c7b\u578b: " + mediaType + "\n" + str2;
        if (this.selectedItem == 2) {
            str3 = str3 + "\u76f8\u4f3c\u5ea6\u4fe1\u606f\uff1a\n\u56fe\u7247\u76f8\u4f3c\u5ea6: " + winkNewAlbumDebugBaseModel.getPhotoSimilarity() + " \n\u53c2\u8003\u56fe\u7247ID: " + winkNewAlbumDebugBaseModel.getSimilarityPhotoID();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("\u56fe\u7247\u4fe1\u606f");
        builder.setMessage(str3);
        builder.setPositiveButton("\u786e\u5b9a", new DialogInterface.OnClickListener() { // from class: u83.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                j.J9(dialogInterface, i3);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void K9() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("\u56fe\u7247\u4fe1\u606f");
        builder.setMessage(this.schema);
        builder.setPositiveButton("\u590d\u5236", new DialogInterface.OnClickListener() { // from class: u83.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                j.L9(j.this, dialogInterface, i3);
            }
        });
        builder.setNegativeButton("\u53d6\u6d88", new DialogInterface.OnClickListener() { // from class: u83.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                j.M9(dialogInterface, i3);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(j this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object systemService = this$0.getContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText("label", this$0.schema));
        QQToast.makeText(this$0.getContext(), "Schema\u4fe1\u606f\u5df2\u62f7\u8d1d", 0).show();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void N9(final int position) {
        Companion companion = INSTANCE;
        final String[] strArr = {companion.a(0), companion.a(1), companion.a(2), companion.a(3)};
        new AlertDialog.Builder(getContext()).setTitle("\u9009\u62e9\u4fe1\u606f").setSingleChoiceItems(strArr, this.selectedItem, new DialogInterface.OnClickListener() { // from class: u83.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                j.O9(j.this, dialogInterface, i3);
            }
        }).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: u83.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                j.P9(strArr, this, position, dialogInterface, i3);
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: u83.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                j.Q9(dialogInterface, i3);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(j this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.selectedItem = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(String[] items, j this$0, int i3, DialogInterface dialogInterface, int i16) {
        Intrinsics.checkNotNullParameter(items, "$items");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = items[this$0.selectedItem];
        QQToast.makeText(this$0.getContext(), str, 0).show();
        Button button = this$0.buttonView;
        if (button != null) {
            button.setText(str);
        }
        this$0.G9(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        Button button;
        Button button2;
        super.onInitView(rootView);
        this.adapter = new b(this);
        if (rootView != null) {
            RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.f790348o);
            this.recyclerView = recyclerView;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new GridLayoutManager(rootView.getContext(), 3));
                recyclerView.setAdapter(this.adapter);
            }
            View findViewById = rootView.findViewById(R.id.tgu);
            if (findViewById instanceof Button) {
                button = (Button) findViewById;
            } else {
                button = null;
            }
            this.buttonView = button;
            if (button != null) {
                button.setText(INSTANCE.a(0));
            }
            View findViewById2 = rootView.findViewById(R.id.f164684th1);
            if (findViewById2 instanceof Button) {
                button2 = (Button) findViewById2;
            } else {
                button2 = null;
            }
            this.schemaButtonView = button2;
            if (button2 != null) {
                button2.setOnClickListener(new View.OnClickListener() { // from class: u83.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        j.F9(j.this, view);
                    }
                });
            }
        }
        Parcelable parcelableExtra = getActivity().getIntent().getParcelableExtra("result");
        Intrinsics.checkNotNull(parcelableExtra);
        WinkNewAlbumDebugPanelViewModel winkNewAlbumDebugPanelViewModel = (WinkNewAlbumDebugPanelViewModel) parcelableExtra;
        this.viewModel = winkNewAlbumDebugPanelViewModel;
        winkNewAlbumDebugPanelViewModel.f(a.INSTANCE.a(winkNewAlbumDebugPanelViewModel.a()));
        H9(this, 0, 1, null);
    }

    @Override // u83.k
    public void onItemClick(int position) {
        N9(position);
    }

    @Override // u83.k
    public void onItemLongClick(int position) {
        I9(position);
    }

    public final void refresh(@NotNull List<WinkNewAlbumDebugBaseModel> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        b bVar = this.adapter;
        if (bVar != null) {
            bVar.l0(data, this.selectedItem);
        }
    }
}
