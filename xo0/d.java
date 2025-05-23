package xo0;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.guild.aio.input.at.quickAt.selectmember.data.GuildAtExpandItemData;
import com.tencent.guild.aio.input.at.quickAt.selectmember.data.GuildAtFolderItemData;
import com.tencent.guild.aio.input.at.quickAt.selectmember.data.e;
import com.tencent.guild.aio.input.at.quickAt.selectmember.data.f;
import com.tencent.guild.aio.input.at.utils.data.AtRoleInfo;
import com.tencent.guild.aio.input.at.utils.data.AtUserWithRoleInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d {
    public static boolean b(int i3) {
        if (i3 < 20) {
            return false;
        }
        QLog.d("GuildAtSelectItemUtils", 1, "checkIsOverSizeSelectedMembers true! currentSelectedSize = " + i3);
        BaseApplication context = BaseApplication.getContext();
        QQToast.makeText(context, 0, context.getString(R.string.f146720uy), 0).show();
        return true;
    }

    public static List<IGProUserInfo> c(List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (com.tencent.guild.aio.input.at.quickAt.selectmember.data.a aVar : list) {
                int a16 = aVar.a();
                if (a16 != 1) {
                    if (a16 != 2) {
                        if (a16 != 3) {
                            if (a16 != 4) {
                                if (a16 == 5) {
                                    arrayList.add(f(((f) aVar).i()));
                                }
                            } else {
                                arrayList.add(e());
                            }
                        } else {
                            arrayList.add(((com.tencent.guild.aio.input.at.quickAt.selectmember.data.d) aVar).i());
                        }
                    } else {
                        arrayList.add(((e) aVar).i());
                    }
                } else {
                    arrayList.add(d());
                }
            }
        }
        return arrayList;
    }

    public static IGProUserInfo d() {
        return new AtUserWithRoleInfo(1, "\u5168\u4f53\u6210\u5458", null);
    }

    public static IGProUserInfo e() {
        return new AtUserWithRoleInfo(64, "\u5728\u7ebf\u6210\u5458", null);
    }

    public static IGProUserInfo f(IGProGuildRoleInfo iGProGuildRoleInfo) {
        return new AtUserWithRoleInfo(8, iGProGuildRoleInfo.getName(), new AtRoleInfo(iGProGuildRoleInfo.getRoleId(), iGProGuildRoleInfo.getName(), Utils.P(iGProGuildRoleInfo.getColor() | (-16777216))));
    }

    public static Drawable g(int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i3);
        gradientDrawable.setCornerRadius(x.c(MobileQQ.sMobileQQ, 28.0f));
        return new LayerDrawable(new Drawable[]{gradientDrawable, ResourcesCompat.getDrawable(MobileQQ.sMobileQQ.getResources(), R.drawable.guild_at_role_icon, null)});
    }

    public static List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> h(List<IGProUserInfo> list, int i3, boolean z16, int i16, int i17, final Function1<List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a>, Unit> function1) {
        boolean z17;
        boolean z18;
        if (i17 == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        final ArrayList arrayList = new ArrayList();
        if (z16) {
            for (IGProUserInfo iGProUserInfo : list) {
                if (iGProUserInfo.getRobotType() == 1) {
                    if (!z17) {
                        e eVar = new e();
                        eVar.j(iGProUserInfo);
                        arrayList.add(eVar);
                    }
                } else {
                    com.tencent.guild.aio.input.at.quickAt.selectmember.data.d dVar = new com.tencent.guild.aio.input.at.quickAt.selectmember.data.d();
                    dVar.j(iGProUserInfo);
                    arrayList.add(dVar);
                }
            }
            return arrayList;
        }
        Function1 function12 = new Function1() { // from class: xo0.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit i18;
                i18 = d.i(arrayList, function1, (Function1) obj);
                return i18;
            }
        };
        ArrayList arrayList2 = new ArrayList();
        if (!z17) {
            for (IGProUserInfo iGProUserInfo2 : list) {
                if (iGProUserInfo2.getRobotType() == 1) {
                    e eVar2 = new e();
                    eVar2.f("\u673a\u5668\u4eba");
                    eVar2.j(iGProUserInfo2);
                    arrayList2.add(eVar2);
                }
            }
        }
        if (arrayList2.size() > 0) {
            arrayList.add(new GuildAtFolderItemData("\u673a\u5668\u4eba", function12, true));
            if (arrayList2.size() > 6) {
                arrayList.addAll(arrayList2.subList(0, 5));
                arrayList.add(new GuildAtExpandItemData("\u673a\u5668\u4eba", arrayList2.subList(5, arrayList2.size()), function12));
            } else {
                arrayList.addAll(arrayList2);
            }
            z18 = true;
        } else {
            z18 = false;
        }
        ArrayList arrayList3 = new ArrayList();
        for (IGProUserInfo iGProUserInfo3 : list) {
            if (iGProUserInfo3.getRobotType() != 1) {
                com.tencent.guild.aio.input.at.quickAt.selectmember.data.d dVar2 = new com.tencent.guild.aio.input.at.quickAt.selectmember.data.d();
                dVar2.f("\u6210\u5458");
                dVar2.j(iGProUserInfo3);
                arrayList3.add(dVar2);
            }
        }
        if (arrayList3.size() > 0) {
            if (z18) {
                arrayList.add(new com.tencent.guild.aio.input.at.quickAt.selectmember.data.b());
            }
            if (!z17) {
                arrayList.add(new GuildAtFolderItemData("\u6210\u5458", function12, false));
            }
            arrayList.addAll(arrayList3);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit i(ArrayList arrayList, Function1 function1, Function1 function12) {
        function12.invoke(arrayList);
        function1.invoke(arrayList);
        return null;
    }
}
