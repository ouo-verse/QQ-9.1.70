package qm4;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.timi.game.smoba.impl.config.b;
import java.util.List;
import trpc.yes.common.GameDataServerOuterClass$GetSmobaConfigRsp;
import trpc.yes.common.GameDataServerOuterClass$SmobaBigGradeLevel;
import trpc.yes.common.GameDataServerOuterClass$SmobaGameMode;
import trpc.yes.common.GameDataServerOuterClass$SmobaLadderGrade;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a implements pm4.a {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseArray<String> f429089a;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        f429089a = sparseArray;
        sparseArray.put(1, "QQ\u5b89\u5353");
        sparseArray.put(2, "QQ\u82f9\u679c");
        sparseArray.put(3, "\u5fae\u4fe1\u5b89\u5353");
        sparseArray.put(4, "\u5fae\u4fe1\u82f9\u679c");
        sparseArray.put(6, "QQ\u5b89\u5353\u62a2\u5148\u670d");
        sparseArray.put(7, "\u5fae\u4fe1\u5b89\u5353\u62a2\u5148\u670d");
        sparseArray.put(60, "QQ\u5b89\u5353\u4f53\u9a8c\u670d");
        sparseArray.put(61, "QQ\u82f9\u679c\u4f53\u9a8c\u670d");
        sparseArray.put(62, "\u5fae\u4fe1\u5b89\u5353\u4f53\u9a8c\u670d");
        sparseArray.put(63, "\u5fae\u4fe1\u82f9\u679c\u4f53\u9a8c\u670d");
        sparseArray.put(210, "QQ\u5b89\u5353\u6d4b\u8bd5\u670d");
        sparseArray.put(211, "QQ\u82f9\u679c\u6d4b\u8bd5\u670d");
        sparseArray.put(212, "\u5fae\u4fe1\u5b89\u5353\u6d4b\u8bd5\u670d");
        sparseArray.put(213, "\u5fae\u4fe1\u82f9\u679c\u6d4b\u8bd5\u670d");
    }

    @Override // pm4.a
    public GameDataServerOuterClass$SmobaLadderGrade T(int i3) {
        List<GameDataServerOuterClass$SmobaLadderGrade> list;
        GameDataServerOuterClass$GetSmobaConfigRsp c16 = b.b().c();
        if (c16 != null) {
            list = c16.ladder_grade_conf_list.get();
        } else {
            list = null;
        }
        if (list != null && list.size() > 0) {
            for (GameDataServerOuterClass$SmobaLadderGrade gameDataServerOuterClass$SmobaLadderGrade : list) {
                if (gameDataServerOuterClass$SmobaLadderGrade.disp_grade_level.get() == i3) {
                    return gameDataServerOuterClass$SmobaLadderGrade;
                }
            }
        }
        return null;
    }

    @Override // pm4.a
    public boolean U0(int i3) {
        if (i3 == 1 || i3 == 3 || i3 == 6 || i3 == 7 || i3 == 60 || i3 == 62 || i3 == 210 || i3 == 212) {
            return true;
        }
        return false;
    }

    @Override // pm4.a
    public String W2(List<Integer> list) {
        List<GameDataServerOuterClass$SmobaBigGradeLevel> list2;
        if (list != null && list.size() != 0) {
            GameDataServerOuterClass$GetSmobaConfigRsp c16 = b.b().c();
            if (c16 != null) {
                list2 = c16.big_grade_level_conf_list.get();
            } else {
                list2 = null;
            }
            if (list2 == null || list2.size() == 0 || list.size() >= list2.size()) {
                return "\u6bb5\u4f4d\u4e0d\u9650";
            }
            if (list.size() == 1) {
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    GameDataServerOuterClass$SmobaBigGradeLevel gameDataServerOuterClass$SmobaBigGradeLevel = list2.get(i3);
                    if (gameDataServerOuterClass$SmobaBigGradeLevel.big_grade_level.get() == list.get(0).intValue()) {
                        return gameDataServerOuterClass$SmobaBigGradeLevel.short_level_name.get();
                    }
                }
            } else {
                int intValue = list.get(0).intValue();
                int intValue2 = list.get(list.size() - 1).intValue();
                String str = "";
                String str2 = "";
                for (int i16 = 0; i16 < list2.size(); i16++) {
                    GameDataServerOuterClass$SmobaBigGradeLevel gameDataServerOuterClass$SmobaBigGradeLevel2 = list2.get(i16);
                    if (gameDataServerOuterClass$SmobaBigGradeLevel2.big_grade_level.get() == intValue) {
                        str = gameDataServerOuterClass$SmobaBigGradeLevel2.merge_show_begin.get();
                    }
                    if (gameDataServerOuterClass$SmobaBigGradeLevel2.big_grade_level.get() == intValue2) {
                        str2 = gameDataServerOuterClass$SmobaBigGradeLevel2.merge_show_end.get();
                    }
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    return str + str2;
                }
            }
        }
        return "\u6bb5\u4f4d\u4e0d\u9650";
    }

    @Override // pm4.a
    public GameDataServerOuterClass$SmobaGameMode t0(int i3) {
        List<GameDataServerOuterClass$SmobaGameMode> list;
        GameDataServerOuterClass$GetSmobaConfigRsp c16 = b.b().c();
        if (c16 != null) {
            list = c16.game_mode_conf_list.get();
        } else {
            list = null;
        }
        if (list != null && list.size() > 0) {
            for (GameDataServerOuterClass$SmobaGameMode gameDataServerOuterClass$SmobaGameMode : list) {
                if (gameDataServerOuterClass$SmobaGameMode.game_mode.get() == i3) {
                    return gameDataServerOuterClass$SmobaGameMode;
                }
            }
        }
        return null;
    }

    @Override // pm4.a
    public int u0(int i3) {
        GameDataServerOuterClass$SmobaLadderGrade T = T(i3);
        if (T != null) {
            return T.big_grade_level.get();
        }
        return 0;
    }

    @Override // pm4.a
    public String w0(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return "\u6e38\u8d70";
                    }
                    return "\u6253\u91ce";
                }
                return "\u53d1\u80b2\u8def";
            }
            return "\u4e2d\u8def";
        }
        return "\u5bf9\u6297\u8def";
    }

    @Override // mm4.a
    public void o2() {
    }

    @Override // mm4.a
    public void init(Context context) {
    }
}
