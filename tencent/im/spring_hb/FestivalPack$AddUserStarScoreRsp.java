package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class FestivalPack$AddUserStarScoreRsp extends MessageMicro<FestivalPack$AddUserStarScoreRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"add_score", "toast_msg"}, new Object[]{0, ""}, FestivalPack$AddUserStarScoreRsp.class);
    public final PBInt32Field add_score = PBField.initInt32(0);
    public final PBStringField toast_msg = PBField.initString("");
}
