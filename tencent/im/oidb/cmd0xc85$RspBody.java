package tencent.im.oidb;

import com.tencent.luggage.wxa.uf.h;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xc85$RspBody extends MessageMicro<cmd0xc85$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{808, 816, BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO}, new String[]{"uint32_result", "uint32_recent_interaction_time", "interaction_detail_info"}, new Object[]{0, 0, null}, cmd0xc85$RspBody.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recent_interaction_time = PBField.initUInt32(0);
    public cmd0xc85$InteractionDetailInfo interaction_detail_info = new MessageMicro<cmd0xc85$InteractionDetailInfo>() { // from class: tencent.im.oidb.cmd0xc85$InteractionDetailInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{808, 816, 824, 834, h.CTRL_INDEX}, new String[]{"uint32_continuous_record_days", "uint32_send_day_time", "uint32_recv_day_time", "str_send_record", "str_recv_record"}, new Object[]{0, 0, 0, "", ""}, cmd0xc85$InteractionDetailInfo.class);
        public final PBUInt32Field uint32_continuous_record_days = PBField.initUInt32(0);
        public final PBUInt32Field uint32_send_day_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_recv_day_time = PBField.initUInt32(0);
        public final PBStringField str_send_record = PBField.initString("");
        public final PBStringField str_recv_record = PBField.initString("");
    };
}
