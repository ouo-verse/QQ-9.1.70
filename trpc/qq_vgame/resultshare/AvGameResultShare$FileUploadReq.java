package trpc.qq_vgame.resultshare;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameResultShare$FileUploadReq extends MessageMicro<AvGameResultShare$FileUploadReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"uin", "play_game_id", "file_type", "file_url"}, new Object[]{0L, "", 0, ""}, AvGameResultShare$FileUploadReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField play_game_id = PBField.initString("");
    public final PBEnumField file_type = PBField.initEnum(0);
    public final PBStringField file_url = PBField.initString("");
}
