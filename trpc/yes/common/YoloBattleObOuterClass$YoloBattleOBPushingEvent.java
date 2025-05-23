package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class YoloBattleObOuterClass$YoloBattleOBPushingEvent extends MessageMicro<YoloBattleObOuterClass$YoloBattleOBPushingEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"status", "pic_url"}, new Object[]{0, ""}, YoloBattleObOuterClass$YoloBattleOBPushingEvent.class);
    public final PBEnumField status = PBField.initEnum(0);
    public final PBStringField pic_url = PBField.initString("");
}
