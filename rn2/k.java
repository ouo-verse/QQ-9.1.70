package rn2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.widget.search.QUISearchBarResource;
import lo2.o;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class k {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends QUISearchBarResource {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBarResource
        public Drawable getBackground(@NonNull QUISearchBar qUISearchBar) {
            if (QQTheme.isVasTheme() && qUISearchBar.getCurColorType() != 1) {
                return AppCompatResources.getDrawable(qUISearchBar.getContext(), R.drawable.skin_searchbar_bg_theme_version2);
            }
            return super.getBackground(qUISearchBar);
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBarResource
        public Drawable getInputBackground(@NonNull QUISearchBar qUISearchBar) {
            if (QQTheme.isVasTheme() && qUISearchBar.getCurColorType() != 1) {
                return AppCompatResources.getDrawable(qUISearchBar.getContext(), R.drawable.skin_searchbar_input_theme_version2);
            }
            return super.getInputBackground(qUISearchBar);
        }
    }

    public static QUISearchBarResource a() {
        return new a();
    }

    public static void b(int i3, int i16, View view, int i17) {
        c(i3, i16, view, false, i17, true);
    }

    public static void c(int i3, int i16, View view, boolean z16, int i17, boolean z17) {
        int intValue = ((Integer) view.getTag(R.id.kxc)).intValue();
        if (view instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) view;
            linearLayout.removeView(linearLayout.findViewById(R.id.gtp));
            linearLayout.removeView(linearLayout.findViewById(R.id.gtq));
            if (linearLayout.getChildCount() == 1) {
                Context context = linearLayout.getContext();
                View childAt = linearLayout.getChildAt(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.alj);
                int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.alk);
                if (i16 != 0) {
                    if (i16 != 1) {
                        if (i16 == 2) {
                            layoutParams.topMargin = 0;
                            layoutParams.bottomMargin = 0;
                        }
                    } else {
                        layoutParams.topMargin = 0;
                        layoutParams.bottomMargin = 0;
                    }
                } else {
                    layoutParams.topMargin = 0;
                    layoutParams.bottomMargin = 0;
                }
                childAt.setLayoutParams(layoutParams);
                if (z17) {
                    if (i3 > 1) {
                        childAt.setPadding(childAt.getPaddingLeft(), dimensionPixelSize, childAt.getPaddingRight(), dimensionPixelSize);
                    } else {
                        childAt.setPadding(childAt.getPaddingLeft(), dimensionPixelSize2, childAt.getPaddingRight(), dimensionPixelSize2);
                    }
                }
                if (o.k(i17)) {
                    View view2 = new com.tencent.mobileqq.search.business.net.view.e(context, i17).getView();
                    view2.setId(R.id.gtq);
                    linearLayout.addView(view2, 0);
                }
                if ((i16 == 0 || i3 == 1) && z16 && intValue != 1) {
                    View view3 = new View(linearLayout.getContext());
                    view3.setId(R.id.gtp);
                    view3.setLayoutParams(new LinearLayout.LayoutParams(-1, linearLayout.getContext().getResources().getDimensionPixelSize(R.dimen.ald)));
                    linearLayout.addView(view3, 0);
                    if (ThemeUtil.isInNightMode(MobileQQ.sMobileQQ.peekAppRuntime())) {
                        view3.setBackgroundColor(Color.parseColor("#080808"));
                    } else {
                        view3.setBackgroundColor(Color.parseColor("#f2f2f2"));
                    }
                }
            }
        }
    }

    public static boolean d(AppInterface appInterface, String str) {
        return ((ITroopRobotService) appInterface.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(str);
    }

    public static void e(y yVar, int i3, int i16) {
        int i17;
        int i18 = 1;
        if (i3 > 1) {
            if (i16 == 0) {
                i17 = 0;
            } else if (i16 == i3 - 1) {
                i17 = 2;
            }
            i18 = i17;
        }
        yVar.w(i3, i18);
    }
}
