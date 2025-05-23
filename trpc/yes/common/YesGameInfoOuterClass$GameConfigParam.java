package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class YesGameInfoOuterClass$GameConfigParam extends MessageMicro<YesGameInfoOuterClass$GameConfigParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"team_name", "game_id", "list_param"}, new Object[]{"", 0, ""}, YesGameInfoOuterClass$GameConfigParam.class);
    public final PBStringField team_name = PBField.initString("");
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBRepeatField<String> list_param = PBField.initRepeat(PBStringField.__repeatHelper__);
}
