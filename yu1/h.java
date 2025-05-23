package yu1;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.r;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ux1.e;
import yx1.RoleSelectItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\bD\u0010EJ \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J>\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u000fH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J0\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\b\u001a\u00020\u0007J\u0012\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016J*\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u001e\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u000ej\b\u0012\u0004\u0012\u00020\u001f`\u000fJ\u0006\u0010!\u001a\u00020\u001bJ\u0006\u0010\"\u001a\u00020\tR\u0016\u0010$\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010#R\u0016\u0010&\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010(\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010#R\u0016\u0010)\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010#R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u0010#R\u0016\u00108\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u0010#R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006F"}, d2 = {"Lyu1/h;", "Landroid/view/View$OnClickListener;", "Lux1/e$a;", "Landroid/view/View;", "view", "Landroidx/fragment/app/Fragment;", "fragment", "", IProfileCardConst.KEY_FROM_TYPE, "", "g", "", "guildId", "channelId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "selectedRoleList", "d", "l", "Lyu1/d;", "data", "i", "v", NodeProps.ON_CLICK, "Lyx1/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "position", "", "checked", "m9", "Yf", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "c", tl.h.F, "k", "Landroid/view/View;", "mBindAllContainer", "e", "mBindAllIv", "f", "mBindPartIv", "mBindPartContainer", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "mBindPartRoleList", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "mSelectTips", "Lyu1/k;", BdhLogUtil.LogTag.Tag_Conn, "Lyu1/k;", "mSelectRoleViewModel", "D", "mRoleGroupDividerV", "E", "mRoleGroupDividerV2", "Lux1/e;", UserInfo.SEX_FEMALE, "Lux1/e;", "mAdapter", "G", "Lux1/e$a;", "mOnItemSelectedCB", "Lyu1/e;", "H", "Lyu1/e;", "mStyle", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h implements View.OnClickListener, e.a {

    /* renamed from: C, reason: from kotlin metadata */
    private k mSelectRoleViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private View mRoleGroupDividerV;

    /* renamed from: E, reason: from kotlin metadata */
    private View mRoleGroupDividerV2;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ux1.e mAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private e.a mOnItemSelectedCB;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private SelectRoleStyle mStyle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mBindAllContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mBindAllIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View mBindPartIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View mBindPartContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mBindPartRoleList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mSelectTips;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"yu1/h$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f451243a;

        public a(String str) {
            this.f451243a = str;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new k(this.f451243a, r.f232798e), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    private final void d(String guildId, String channelId, final Fragment fragment, ArrayList<String> selectedRoleList) {
        c.Companion companion = ef1.c.INSTANCE;
        ViewModel viewModel = new ViewModelProvider(fragment, new a(guildId)).get(k.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme\u2026oleViewModel::class.java]");
        k kVar = (k) viewModel;
        this.mSelectRoleViewModel = kVar;
        k kVar2 = null;
        if (selectedRoleList != null) {
            if (kVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectRoleViewModel");
                kVar = null;
            }
            kVar.b2(selectedRoleList);
        }
        k kVar3 = this.mSelectRoleViewModel;
        if (kVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectRoleViewModel");
            kVar3 = null;
        }
        kVar3.P1().observe(fragment.getViewLifecycleOwner(), new Observer() { // from class: yu1.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                h.e(h.this, fragment, (List) obj);
            }
        });
        if (channelId != null) {
            k kVar4 = this.mSelectRoleViewModel;
            if (kVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectRoleViewModel");
                kVar4 = null;
            }
            kVar4.X1(channelId);
        } else {
            k kVar5 = this.mSelectRoleViewModel;
            if (kVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectRoleViewModel");
                kVar5 = null;
            }
            kVar5.U1();
        }
        k kVar6 = this.mSelectRoleViewModel;
        if (kVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectRoleViewModel");
        } else {
            kVar2 = kVar6;
        }
        kVar2.Q1().observe(fragment.getViewLifecycleOwner(), new Observer() { // from class: yu1.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                h.f(h.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(h this$0, Fragment fragment, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fragment, "$fragment");
        ux1.e eVar = this$0.mAdapter;
        if (eVar != null) {
            eVar.S0(list);
        }
        k kVar = this$0.mSelectRoleViewModel;
        TextView textView = null;
        k kVar2 = null;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectRoleViewModel");
            kVar = null;
        }
        if (!kVar.R1().isEmpty()) {
            TextView textView2 = this$0.mSelectTips;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectTips");
                textView2 = null;
            }
            Object[] objArr = new Object[1];
            k kVar3 = this$0.mSelectRoleViewModel;
            if (kVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectRoleViewModel");
            } else {
                kVar2 = kVar3;
            }
            objArr[0] = Integer.valueOf(kVar2.R1().size());
            textView2.setText(fragment.getString(R.string.f155691i7, objArr));
            return;
        }
        TextView textView3 = this$0.mSelectTips;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectTips");
        } else {
            textView = textView3;
        }
        textView.setText(HardCodeUtil.qqStr(R.string.f155671i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(h this$0, Boolean selectAll) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(selectAll, "selectAll");
        TextView textView = null;
        if (selectAll.booleanValue()) {
            View view = this$0.mBindAllIv;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBindAllIv");
                view = null;
            }
            view.setVisibility(0);
            View view2 = this$0.mBindPartIv;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBindPartIv");
                view2 = null;
            }
            view2.setVisibility(8);
            RecyclerView recyclerView = this$0.mBindPartRoleList;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBindPartRoleList");
                recyclerView = null;
            }
            recyclerView.setVisibility(8);
            TextView textView2 = this$0.mSelectTips;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectTips");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        View view3 = this$0.mBindAllIv;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindAllIv");
            view3 = null;
        }
        view3.setVisibility(8);
        View view4 = this$0.mBindPartIv;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindPartIv");
            view4 = null;
        }
        view4.setVisibility(0);
        RecyclerView recyclerView2 = this$0.mBindPartRoleList;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindPartRoleList");
            recyclerView2 = null;
        }
        recyclerView2.setVisibility(0);
        TextView textView3 = this$0.mSelectTips;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectTips");
        } else {
            textView = textView3;
        }
        textView.setVisibility(0);
    }

    private final void g(View view, Fragment fragment, int fromType) {
        String str;
        String str2;
        View findViewById = view.findViewById(R.id.w0n);
        findViewById.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<View>(\u2026s@SelectRoleVB)\n        }");
        this.mBindAllContainer = findViewById;
        View findViewById2 = view.findViewById(R.id.w0l);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.guild_bind_all_iv)");
        this.mBindAllIv = findViewById2;
        View findViewById3 = view.findViewById(R.id.w0m);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.guild_bind_part_iv)");
        this.mBindPartIv = findViewById3;
        View findViewById4 = view.findViewById(R.id.ima);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.select_tips)");
        this.mSelectTips = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.w0r);
        findViewById5.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById<View>(\u2026s@SelectRoleVB)\n        }");
        this.mBindPartContainer = findViewById5;
        View findViewById6 = view.findViewById(R.id.wx8);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.guild_role_group_divider)");
        this.mRoleGroupDividerV = findViewById6;
        View findViewById7 = view.findViewById(R.id.wx9);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.guild_role_group_divider2)");
        this.mRoleGroupDividerV2 = findViewById7;
        View findViewById8 = view.findViewById(R.id.wxb);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.g\u2026d_role_group_select_list)");
        this.mBindPartRoleList = (RecyclerView) findViewById8;
        RecyclerView recyclerView = null;
        this.mAdapter = new ux1.e(this, null, fromType);
        RecyclerView recyclerView2 = this.mBindPartRoleList;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindPartRoleList");
            recyclerView2 = null;
        }
        recyclerView2.setNestedScrollingEnabled(false);
        RecyclerView recyclerView3 = this.mBindPartRoleList;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindPartRoleList");
            recyclerView3 = null;
        }
        recyclerView3.setLayoutManager(new LinearLayoutManager(fragment.getContext(), 1, false));
        SelectRoleStyle selectRoleStyle = this.mStyle;
        if (selectRoleStyle != null) {
            str = selectRoleStyle.getDividerColor();
        } else {
            str = null;
        }
        if (str != null) {
            SelectRoleStyle selectRoleStyle2 = this.mStyle;
            Intrinsics.checkNotNull(selectRoleStyle2);
            str2 = selectRoleStyle2.getDividerColor();
        } else if (GuildThemeManager.f235286a.b()) {
            str2 = "#FF151516";
        } else {
            str2 = "#FFDEDFD0";
        }
        RecyclerView recyclerView4 = this.mBindPartRoleList;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindPartRoleList");
            recyclerView4 = null;
        }
        recyclerView4.addItemDecoration(new com.tencent.mobileqq.guild.widget.k(new ColorDrawable(Color.parseColor(str2)), ViewUtils.dpToPx(16.0f), 0));
        RecyclerView recyclerView5 = this.mBindPartRoleList;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindPartRoleList");
        } else {
            recyclerView = recyclerView5;
        }
        recyclerView.setAdapter(this.mAdapter);
        l();
    }

    public static /* synthetic */ void j(h hVar, View view, String str, Fragment fragment, SelectRoleData selectRoleData, int i3, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            i3 = 1;
        }
        hVar.i(view, str, fragment, selectRoleData, i3);
    }

    private final void l() {
        SelectRoleStyle selectRoleStyle = this.mStyle;
        if (selectRoleStyle != null) {
            View view = this.mBindAllContainer;
            View view2 = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBindAllContainer");
                view = null;
            }
            ((TextView) view.findViewById(R.id.w0p)).setTextColor(selectRoleStyle.getTextColor());
            View view3 = this.mBindPartContainer;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBindPartContainer");
                view3 = null;
            }
            ((TextView) view3.findViewById(R.id.w0t)).setTextColor(selectRoleStyle.getTextColor());
            View view4 = this.mBindAllContainer;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBindAllContainer");
                view4 = null;
            }
            view4.setBackground(selectRoleStyle.getBackgroundDrawable());
            View view5 = this.mBindPartContainer;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBindPartContainer");
                view5 = null;
            }
            view5.setBackground(selectRoleStyle.getBackgroundDrawable());
            View view6 = this.mRoleGroupDividerV;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRoleGroupDividerV");
                view6 = null;
            }
            view6.setBackgroundColor(Color.parseColor(selectRoleStyle.getDividerColor()));
            View view7 = this.mRoleGroupDividerV2;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRoleGroupDividerV2");
            } else {
                view2 = view7;
            }
            view2.setBackgroundColor(Color.parseColor(selectRoleStyle.getDividerColor()));
        }
    }

    @Override // ux1.e.a
    public void Yf(@Nullable View view) {
        SelectRoleStyle selectRoleStyle = this.mStyle;
        if (selectRoleStyle != null && view != null) {
            ((TextView) view.findViewById(R.id.title)).setTextColor(selectRoleStyle.getTextColor());
            view.setBackground(selectRoleStyle.getBackgroundDrawable());
        }
    }

    @NotNull
    public final ArrayList<RoleGroupModel> c() {
        k kVar = this.mSelectRoleViewModel;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectRoleViewModel");
            kVar = null;
        }
        return kVar.S1();
    }

    public final boolean h() {
        k kVar = this.mSelectRoleViewModel;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectRoleViewModel");
            kVar = null;
        }
        return Intrinsics.areEqual(kVar.Q1().getValue(), Boolean.TRUE);
    }

    public final void i(@NotNull View view, @NotNull String guildId, @NotNull Fragment fragment, @NotNull SelectRoleData data, int fromType) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(data, "data");
        this.mStyle = data.getStyle();
        g(view, fragment, fromType);
        d(guildId, data.getChannelId(), fragment, data.c());
        this.mOnItemSelectedCB = data.getOnItemSelected();
    }

    public final void k() {
        View view = this.mBindAllContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindAllContainer");
            view = null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = 0;
        }
    }

    @Override // ux1.e.a
    public void m9(@NotNull RoleSelectItem item, int position, boolean checked, @Nullable View view) {
        Intrinsics.checkNotNullParameter(item, "item");
        k kVar = this.mSelectRoleViewModel;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectRoleViewModel");
            kVar = null;
        }
        kVar.a2(item, checked);
        e.a aVar = this.mOnItemSelectedCB;
        if (aVar != null) {
            aVar.m9(item, position, checked, view);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        View view = this.mBindAllContainer;
        k kVar = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindAllContainer");
            view = null;
        }
        if (Intrinsics.areEqual(v3, view)) {
            k kVar2 = this.mSelectRoleViewModel;
            if (kVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectRoleViewModel");
                kVar2 = null;
            }
            kVar2.c2(true);
            k kVar3 = this.mSelectRoleViewModel;
            if (kVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectRoleViewModel");
            } else {
                kVar = kVar3;
            }
            kVar.b2(new ArrayList<>());
        } else {
            View view2 = this.mBindPartContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBindPartContainer");
                view2 = null;
            }
            if (Intrinsics.areEqual(v3, view2)) {
                k kVar4 = this.mSelectRoleViewModel;
                if (kVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSelectRoleViewModel");
                } else {
                    kVar = kVar4;
                }
                kVar.c2(false);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
