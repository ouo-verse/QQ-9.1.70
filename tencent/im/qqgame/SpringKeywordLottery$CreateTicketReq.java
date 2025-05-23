package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SpringKeywordLottery$CreateTicketReq extends MessageMicro<SpringKeywordLottery$CreateTicketReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ticket", "act_id"}, new Object[]{null, ""}, SpringKeywordLottery$CreateTicketReq.class);
    public SpringKeywordLottery$Ticket ticket = new MessageMicro<SpringKeywordLottery$Ticket>() { // from class: tencent.im.qqgame.SpringKeywordLottery$Ticket
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"sender", "receiver", "ticket_type", "keyword"}, new Object[]{"", "", 0, ""}, SpringKeywordLottery$Ticket.class);
        public final PBStringField sender = PBField.initString("");
        public final PBStringField receiver = PBField.initString("");
        public final PBEnumField ticket_type = PBField.initEnum(0);
        public final PBStringField keyword = PBField.initString("");
    };
    public final PBStringField act_id = PBField.initString("");
}
