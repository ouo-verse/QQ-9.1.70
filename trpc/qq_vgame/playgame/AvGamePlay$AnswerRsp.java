package trpc.qq_vgame.playgame;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* loaded from: classes29.dex */
public final class AvGamePlay$AnswerRsp extends MessageMicro<AvGamePlay$AnswerRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"res", "answer_result", LocalPhotoFaceInfo.SCORE, "right_answer"}, new Object[]{null, 0, 0, ""}, AvGamePlay$AnswerRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
    public final PBUInt32Field answer_result = PBField.initUInt32(0);
    public final PBUInt32Field score = PBField.initUInt32(0);
    public final PBStringField right_answer = PBField.initString("");
}
