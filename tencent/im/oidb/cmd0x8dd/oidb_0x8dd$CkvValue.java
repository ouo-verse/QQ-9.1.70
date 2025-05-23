package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8dd$CkvValue extends MessageMicro<oidb_0x8dd$CkvValue> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_people_cache", "msg_anchor_cache"}, new Object[]{null, null}, oidb_0x8dd$CkvValue.class);
    public oidb_0x8dd$PeopleCache msg_people_cache = new MessageMicro<oidb_0x8dd$PeopleCache>() { // from class: tencent.im.oidb.cmd0x8dd.oidb_0x8dd$PeopleCache
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_people"}, new Object[]{null}, oidb_0x8dd$PeopleCache.class);
        public final PBRepeatMessageField<oidb_0x8dd$NearbyPeople> rpt_msg_people = PBField.initRepeatMessage(oidb_0x8dd$NearbyPeople.class);
    };
    public oidb_0x8dd$AnchorCache msg_anchor_cache = new MessageMicro<oidb_0x8dd$AnchorCache>() { // from class: tencent.im.oidb.cmd0x8dd.oidb_0x8dd$AnchorCache
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_anchor"}, new Object[]{null}, oidb_0x8dd$AnchorCache.class);
        public final PBRepeatMessageField<oidb_0x8dd$NearbyPeople> rpt_msg_anchor = PBField.initRepeatMessage(oidb_0x8dd$NearbyPeople.class);
    };
}
