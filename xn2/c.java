package xn2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.search.model.k;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.TokenResUtils;
import java.util.ArrayList;
import java.util.Set;
import wn2.ContactSearchModelNtBuddy;
import wn2.j;
import wn2.n;
import wn2.p;
import wn2.q;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends qn2.f {

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.search.view.d f448192e;

    /* renamed from: f, reason: collision with root package name */
    protected Set<String> f448193f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements View.OnLongClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ y f448194d;

        a(y yVar) {
            this.f448194d = yVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle(HardCodeUtil.qqStr(R.string.l3k));
            long I = ((k) this.f448194d).I();
            StringBuilder sb5 = new StringBuilder();
            int i3 = SearchConfig.contactSearchPinyinBaseBit;
            sb5.append("\u62fc\u97f3\u5339\u914d\uff1a");
            sb5.append(((9223372036854775807 << i3) & I) >> i3);
            sb5.append('\n');
            int i16 = SearchConfig.contactSearchRecentBaseBit;
            sb5.append("\u6700\u8fd1\u8054\u7cfb\u4eba\u6392\u5e8f\uff1a");
            sb5.append((((9223372036854775807 >> (63 - (i16 + 10))) & I) & (9223372036854775807 << i16)) >> i16);
            sb5.append('\n');
            int i17 = SearchConfig.contactSearchIndexBaseBit;
            sb5.append("\u5b57\u7b26\u4e32\u5339\u914d\u5ea6\uff1a");
            sb5.append((((9223372036854775807 >> (63 - (i17 + 8))) & I) & (9223372036854775807 << i17)) >> i17);
            sb5.append('\n');
            int i18 = SearchConfig.contactSearchTypeBaseBit;
            sb5.append("\u6570\u636e\u7c7b\u578b\uff1a");
            sb5.append((((9223372036854775807 >> (63 - (i18 + 8))) & I) & (9223372036854775807 << i18)) >> i18);
            sb5.append('\n');
            int i19 = SearchConfig.contactSearchFieldBaseBit;
            sb5.append("\u5b57\u6bb5\u7c7b\u578b\uff1a");
            sb5.append(((I & (9223372036854775807 >> (63 - (i19 + 8)))) & (9223372036854775807 << i19)) >> i19);
            sb5.append('\n');
            builder.setMessage(sb5.toString());
            builder.create().show();
            EventCollector.getInstance().onViewLongClicked(view);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ y f448196d;

        b(y yVar) {
            this.f448196d = yVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Context context = view.getContext();
            String l3 = this.f448196d.l();
            if (context instanceof QBaseActivity) {
                SearchUtils.W0("all_result", "clk_result_join", new String[0]);
                c.this.q((QBaseActivity) context, l3);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* renamed from: xn2.c$c, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    class ViewOnClickListenerC11555c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f448198d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f448199e;

        ViewOnClickListenerC11555c(String str, String str2) {
            this.f448198d = str;
            this.f448199e = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            view.setTag(2021012801, this.f448198d);
            view.setTag(2021012802, this.f448199e);
            c.this.f448192e.onAction(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public c(IFaceDecoder iFaceDecoder) {
        super(iFaceDecoder);
        this.f448192e = null;
    }

    private void p(y yVar, sn2.c cVar) {
        RelativeLayout.LayoutParams layoutParams;
        if ((cVar instanceof yn2.c) && (yVar instanceof q)) {
            q qVar = (q) yVar;
            if (qVar.f445977e0 == 3 && cVar.getView() != null) {
                TextView textView = (TextView) cVar.getView().findViewById(R.id.i6s);
                CharSequence R = qVar.R();
                if (textView != null && !TextUtils.isEmpty(R)) {
                    textView.setVisibility(0);
                    textView.setText(R);
                }
                TextView b16 = cVar.b();
                if (b16 != null && (layoutParams = (RelativeLayout.LayoutParams) b16.getLayoutParams()) != null) {
                    layoutParams.addRule(15, 0);
                    b16.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Activity activity, String str) {
        Intent intent = new Intent();
        intent.putExtra("param_type", 3000);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 0);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 1002);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, 99);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 29);
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.tencent.mobileqq.selectmember.e.a(str, "", 0, str));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SELECTED_RECORDS_FOR_CREATE_DISCURRION, arrayList);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(activity, intent, 1300);
    }

    @Override // qn2.f, qn2.d
    /* renamed from: g */
    public void a(y yVar, sn2.c cVar) {
        int i3;
        super.a(yVar, cVar);
        if ((yVar instanceof p) && yVar.m() == null) {
            if (cVar.k() != null) {
                cVar.k().setVisibility(8);
            }
            if (cVar.b() != null) {
                cVar.b().setVisibility(8);
            }
            if (cVar.c() != null) {
                cVar.c().setVisibility(8);
            }
            TextView o16 = ((yn2.c) cVar).o();
            if (o16 != null) {
                o16.setVisibility(0);
                o16.setText(yVar.getTitleSpans());
            }
        } else {
            if (cVar.k() != null && !TextUtils.isEmpty(yVar.m())) {
                cVar.k().setVisibility(0);
            } else if (cVar.k() != null) {
                cVar.k().setVisibility(8);
            }
            if (cVar.b() != null) {
                cVar.b().setVisibility(0);
            }
            if (cVar.c() != null && yVar.getSubTitleSpans() != null) {
                cVar.c().setVisibility(0);
                if (!(yVar instanceof wn2.c) && !(yVar instanceof wn2.b) && !(yVar instanceof j)) {
                    cVar.c().setCompoundDrawables(null, null, null, null);
                } else {
                    String l3 = yVar.l();
                    if (!TextUtils.isEmpty(l3) && Utils.G(l3)) {
                        Drawable drawable = cVar.c().getContext().getResources().getDrawable(R.drawable.br7);
                        drawable.setBounds(0, 0, SearchUtils.l(15.0f, cVar.c().getContext().getResources()), SearchUtils.l(15.0f, cVar.c().getContext().getResources()));
                        ThemeUtil.setThemeFilter(drawable, ThemeUtil.curThemeId);
                        cVar.c().setCompoundDrawables(null, null, drawable, null);
                    } else {
                        cVar.c().setCompoundDrawables(null, null, null, null);
                    }
                }
            } else if (cVar.c() != null) {
                cVar.c().setVisibility(8);
            }
            TextView o17 = ((yn2.c) cVar).o();
            if (o17 != null) {
                o17.setVisibility(8);
            }
        }
        View findViewById = cVar.getView().findViewById(R.id.kab);
        if (findViewById != null) {
            findViewById.setVisibility(8);
            if ((yVar instanceof wn2.g) || (yVar instanceof n) || (yVar instanceof wn2.c) || (yVar instanceof ContactSearchModelNtBuddy)) {
                if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isRobotUin(yVar.l())) {
                    findViewById.setVisibility(0);
                }
            }
        }
        if (cVar.k() != null) {
            String l16 = yVar.l();
            Set<String> set = this.f448193f;
            if (set != null && set.contains(l16)) {
                cVar.k().setText(HardCodeUtil.qqStr(R.string.l3v));
            }
        }
        p(yVar, cVar);
        if (SearchUtils.f284952a && cVar.getView() != null && (yVar instanceof k)) {
            cVar.getView().setOnLongClickListener(new a(yVar));
        }
        if (!com.tencent.mobileqq.search.util.y.d() && cVar.g() != null && (yVar instanceof wn2.c)) {
            int T = ((wn2.c) yVar).T();
            if (QLog.isColorLevel()) {
                QLog.d("ContactSearchResultPresenter", 2, "add from type =" + T);
            }
            if (T == 21 || T == 1 || T == 2) {
                ImageView g16 = cVar.g();
                g16.setContentDescription(g16.getContext().getString(R.string.vvg));
                if (TokenResUtils.useTokenRes3()) {
                    i3 = R.drawable.qui_group_building_icon_secondary_01;
                } else {
                    i3 = R.drawable.qq_search_create_troop_icon;
                }
                g16.setImageResource(i3);
                if (SimpleUIUtil.isNowElderMode()) {
                    g16.setScaleType(ImageView.ScaleType.CENTER);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) g16.getLayoutParams();
                    layoutParams.height = ViewUtils.dpToPx(44.0f);
                    layoutParams.width = ViewUtils.dpToPx(44.0f);
                }
                g16.setOnClickListener(new b(yVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // qn2.f
    public void h(y yVar, sn2.c cVar) {
        String str;
        if (this.f448192e != null) {
            if (cVar.getView() != null) {
                boolean z16 = yVar instanceof q;
                String str2 = "";
                if (!z16) {
                    str = "";
                } else {
                    str = ((q) yVar).a().getTroopDisplayName();
                }
                if (z16) {
                    str2 = ((q) yVar).a().getTroopUin();
                }
                cVar.getView().setOnClickListener(new ViewOnClickListenerC11555c(str, str2));
                return;
            }
            return;
        }
        super.h(yVar, cVar);
    }

    @Override // qn2.f, qn2.c
    /* renamed from: i */
    public void c(y yVar, sn2.c cVar) {
        if (yVar instanceof wn2.d) {
            Object n3 = yVar.n(null);
            if (!(n3 instanceof String)) {
                return;
            }
            int dimensionPixelSize = cVar.getView().getResources().getDimensionPixelSize(R.dimen.f159238y4);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = dimensionPixelSize;
            obtain.mRequestHeight = dimensionPixelSize;
            URLDrawable drawable = URLDrawable.getDrawable((String) n3, obtain);
            drawable.setDecodeHandler(((IGameCenterFriendApi) QRoute.api(IGameCenterFriendApi.class)).getRoundFaceDecoder());
            if (drawable.getStatus() != 1 && drawable.getStatus() != 0) {
                drawable.restartDownload();
            }
            cVar.f().setImageDrawable(drawable);
            return;
        }
        super.c(yVar, cVar);
    }

    @Override // qn2.f, qn2.c
    /* renamed from: l */
    public void f(y yVar, sn2.c cVar, Bitmap bitmap) {
        if (yVar.k() == 103) {
            if (cVar.f() != null) {
                cVar.f().setImageDrawable(SearchUtils.r0(bitmap));
                return;
            }
            return;
        }
        super.f(yVar, cVar, bitmap);
    }

    public c(IFaceDecoder iFaceDecoder, com.tencent.mobileqq.search.view.d dVar) {
        super(iFaceDecoder);
        this.f448192e = dVar;
    }

    public c(IFaceDecoder iFaceDecoder, com.tencent.mobileqq.search.view.d dVar, Set<String> set) {
        super(iFaceDecoder);
        this.f448192e = dVar;
        this.f448193f = set;
    }
}
