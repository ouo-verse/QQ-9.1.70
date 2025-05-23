package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* loaded from: classes29.dex */
public final class AvGamePlay$UserShiftQuestionSyncRsp extends MessageMicro<AvGamePlay$UserShiftQuestionSyncRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"seq", "res"}, new Object[]{0L, null}, AvGamePlay$UserShiftQuestionSyncRsp.class);
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public AvGameCommon$Result res = new AvGameCommon$Result();
}
