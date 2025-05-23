package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleSmobaOuterClass$YoloSmobaBattleResultRsp extends MessageMicro<YoloBattleSmobaOuterClass$YoloSmobaBattleResultRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"smoba_battle_results"}, new Object[]{null}, YoloBattleSmobaOuterClass$YoloSmobaBattleResultRsp.class);
    public final PBRepeatMessageField<YoloBattleSmobaOuterClass$YoloSmobaBattleResult> smoba_battle_results = PBField.initRepeatMessage(YoloBattleSmobaOuterClass$YoloSmobaBattleResult.class);
}
