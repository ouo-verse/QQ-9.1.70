package tencent.im.group_pro_proto.oidb0xffa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb0xffa$ArkMessage extends MessageMicro<oidb0xffa$ArkMessage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ark_message_type", "moba_premades_team_message", "ark_json_message"}, new Object[]{0, null, null}, oidb0xffa$ArkMessage.class);
    public final PBEnumField ark_message_type = PBField.initEnum(0);
    public oidb0xffa$MobaPremadesTeamMessage moba_premades_team_message = new MessageMicro<oidb0xffa$MobaPremadesTeamMessage>() { // from class: tencent.im.group_pro_proto.oidb0xffa.oidb0xffa$MobaPremadesTeamMessage
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"team_id"}, new Object[]{0L}, oidb0xffa$MobaPremadesTeamMessage.class);
        public final PBUInt64Field team_id = PBField.initUInt64(0);
    };
    public oidb0xffa$ArkJsonMessage ark_json_message = new oidb0xffa$ArkJsonMessage();
}
