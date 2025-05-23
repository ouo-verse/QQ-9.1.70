package tencent.im.troop_search_searchtab;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class searchtab$Card extends MessageMicro<searchtab$Card> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58}, new String[]{"type", "title_bar", "rpt_item1", "rpt_item2", "rpt_item3", "str_transfer_desc", "str_transfer_url"}, new Object[]{1, null, null, null, null, "", ""}, searchtab$Card.class);
    public final PBEnumField type = PBField.initEnum(1);
    public searchtab$TitleBar title_bar = new MessageMicro<searchtab$TitleBar>() { // from class: tencent.im.troop_search_searchtab.searchtab$TitleBar
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"str_icon_url", "str_desc"}, new Object[]{"", ""}, searchtab$TitleBar.class);
        public final PBStringField str_icon_url = PBField.initString("");
        public final PBStringField str_desc = PBField.initString("");
    };
    public final PBRepeatMessageField<searchtab$Item1> rpt_item1 = PBField.initRepeatMessage(searchtab$Item1.class);
    public final PBRepeatMessageField<searchtab$Item2> rpt_item2 = PBField.initRepeatMessage(searchtab$Item2.class);
    public final PBRepeatMessageField<searchtab$Item3> rpt_item3 = PBField.initRepeatMessage(searchtab$Item3.class);
    public final PBStringField str_transfer_desc = PBField.initString("");
    public final PBStringField str_transfer_url = PBField.initString("");
}
