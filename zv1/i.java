package zv1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.profile.profilecard.dialog.GuildRemoveGuildDialogFragment;
import com.tencent.mobileqq.guild.profile.profilecard.dialog.remove.GuildRemoveGuildDialogViewModel;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.GuildSecondaryAuthorityViewModel;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0007H\u0016R\u0016\u0010\u001c\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010'R\u0016\u0010+\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010'R\u0016\u0010.\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lzv1/i;", "Lzv1/j;", "Landroid/view/View$OnClickListener;", "", "j", "", "isBlack", "", "i", "Lcom/tencent/mobileqq/guild/profile/profilecard/dialog/GuildRemoveGuildDialogFragment;", "fragment", "d", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "a", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/GuildSecondaryAuthorityViewModel;", "authorityViewModel", "Lcom/tencent/mobileqq/guild/profile/profilecard/dialog/remove/GuildRemoveGuildDialogViewModel;", "guildRemoveViewModel", "c", "v", NodeProps.ON_CLICK, "msgRevokeType", "b", "Landroid/view/View;", "mRootView", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "e", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "mRecyclerView", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "f", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "mAdapter", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "mCancel", "mSureButton", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mTitle", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/profile/profilecard/dialog/GuildRemoveGuildDialogFragment;", "mFragment", "D", "Lcom/tencent/mobileqq/guild/profile/profilecard/dialog/remove/GuildRemoveGuildDialogViewModel;", "mGuildRemoveViewModel", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class i implements j, View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private GuildRemoveGuildDialogFragment mFragment;

    /* renamed from: D, reason: from kotlin metadata */
    private GuildRemoveGuildDialogViewModel mGuildRemoveViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUISettingsRecyclerView mRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUIListItemAdapter mAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mCancel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mSureButton;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(i this$0, GuildRemoveGuildDialogViewModel guildRemoveViewModel, int i3) {
        int i16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(guildRemoveViewModel, "$guildRemoveViewModel");
        GuildRemoveGuildDialogViewModel guildRemoveGuildDialogViewModel = this$0.mGuildRemoveViewModel;
        GuildRemoveGuildDialogFragment guildRemoveGuildDialogFragment = null;
        if (guildRemoveGuildDialogViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildRemoveViewModel");
            guildRemoveGuildDialogViewModel = null;
        }
        if (guildRemoveGuildDialogViewModel.getMData().getIsRobot()) {
            i16 = R.string.f152921ap;
        } else {
            GuildRemoveGuildDialogViewModel guildRemoveGuildDialogViewModel2 = this$0.mGuildRemoveViewModel;
            if (guildRemoveGuildDialogViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildRemoveViewModel");
                guildRemoveGuildDialogViewModel2 = null;
            }
            if (guildRemoveGuildDialogViewModel2.getMData().getIsGuildMember()) {
                i16 = R.string.f152911ao;
            } else {
                i16 = R.string.f152931aq;
            }
        }
        QUIListItemAdapter qUIListItemAdapter = this$0.mAdapter;
        if (qUIListItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            qUIListItemAdapter = null;
        }
        Group[] groupArr = new Group[1];
        GuildRemoveGuildDialogFragment guildRemoveGuildDialogFragment2 = this$0.mFragment;
        if (guildRemoveGuildDialogFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFragment");
        } else {
            guildRemoveGuildDialogFragment = guildRemoveGuildDialogFragment2;
        }
        String string = guildRemoveGuildDialogFragment.getString(i16);
        Intrinsics.checkNotNullExpressionValue(string, "mFragment.getString(resId)");
        groupArr[0] = guildRemoveViewModel.getRemoveDialogListConfig(string, i3);
        qUIListItemAdapter.t0(groupArr);
    }

    private final void j() {
        View view = this.mRootView;
        QUIListItemAdapter qUIListItemAdapter = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.ebs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.list_view)");
        this.mRecyclerView = (QUISettingsRecyclerView) findViewById;
        this.mAdapter = new QUIListItemAdapter(null, false, false, 7, null);
        QUISettingsRecyclerView qUISettingsRecyclerView = this.mRecyclerView;
        if (qUISettingsRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            qUISettingsRecyclerView = null;
        }
        QUIListItemAdapter qUIListItemAdapter2 = this.mAdapter;
        if (qUIListItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            qUIListItemAdapter = qUIListItemAdapter2;
        }
        qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(i this$0, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "v");
        this$0.onClick(v3);
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(i this$0, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "v");
        this$0.onClick(v3);
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // zv1.j
    @NotNull
    public View a(@NotNull LayoutInflater inflater, @Nullable ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f4a, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026dialog, container, false)");
        this.mRootView = inflate;
        j();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.cancel);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.cancel)");
        this.mCancel = (TextView) findViewById;
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.f72883s2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.remove_guild)");
        this.mSureButton = (TextView) findViewById2;
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.title)");
        this.mTitle = (TextView) findViewById3;
        TextView textView = this.mCancel;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCancel");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: zv1.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                i.k(i.this, view4);
            }
        });
        TextView textView2 = this.mSureButton;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSureButton");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: zv1.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                i.l(i.this, view4);
            }
        });
        View view4 = this.mRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            return null;
        }
        return view4;
    }

    @Override // zv1.j
    public void b(boolean isBlack, int msgRevokeType) {
        TextView textView = this.mSureButton;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSureButton");
            textView = null;
        }
        ch.Y0(textView, "em_sgrp_remove_channel", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_delete_message", Integer.valueOf(msgRevokeType));
        hashMap.put("sgrp_addto_blacklist", Integer.valueOf(i(isBlack)));
        TextView textView3 = this.mSureButton;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSureButton");
        } else {
            textView2 = textView3;
        }
        VideoReport.reportEvent("clck", textView2, hashMap);
    }

    @Override // zv1.j
    public void c(@NotNull GuildSecondaryAuthorityViewModel authorityViewModel, @NotNull final GuildRemoveGuildDialogViewModel guildRemoveViewModel) {
        Intrinsics.checkNotNullParameter(authorityViewModel, "authorityViewModel");
        Intrinsics.checkNotNullParameter(guildRemoveViewModel, "guildRemoveViewModel");
        this.mGuildRemoveViewModel = guildRemoveViewModel;
        TextView textView = this.mTitle;
        GuildRemoveGuildDialogFragment guildRemoveGuildDialogFragment = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            textView = null;
        }
        textView.setText(guildRemoveViewModel.getMData().getTitle());
        MutableLiveData<Integer> curSelectItemLiveData = guildRemoveViewModel.getCurSelectItemLiveData();
        GuildRemoveGuildDialogFragment guildRemoveGuildDialogFragment2 = this.mFragment;
        if (guildRemoveGuildDialogFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFragment");
        } else {
            guildRemoveGuildDialogFragment = guildRemoveGuildDialogFragment2;
        }
        curSelectItemLiveData.observe(guildRemoveGuildDialogFragment, new Observer() { // from class: zv1.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                i.h(i.this, guildRemoveViewModel, ((Integer) obj).intValue());
            }
        });
    }

    @Override // zv1.j
    public void d(@NotNull GuildRemoveGuildDialogFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.mFragment = fragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        TextView textView = this.mCancel;
        GuildRemoveGuildDialogFragment guildRemoveGuildDialogFragment = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCancel");
            textView = null;
        }
        if (v3 == textView) {
            GuildRemoveGuildDialogFragment guildRemoveGuildDialogFragment2 = this.mFragment;
            if (guildRemoveGuildDialogFragment2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFragment");
            } else {
                guildRemoveGuildDialogFragment = guildRemoveGuildDialogFragment2;
            }
            guildRemoveGuildDialogFragment.dismiss();
        } else {
            TextView textView2 = this.mSureButton;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSureButton");
                textView2 = null;
            }
            if (v3 == textView2) {
                GuildRemoveGuildDialogFragment guildRemoveGuildDialogFragment3 = this.mFragment;
                if (guildRemoveGuildDialogFragment3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFragment");
                } else {
                    guildRemoveGuildDialogFragment = guildRemoveGuildDialogFragment3;
                }
                guildRemoveGuildDialogFragment.sh();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    private final int i(boolean isBlack) {
        return isBlack ? 1 : 0;
    }
}
