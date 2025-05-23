package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x533$HttpCardV2 extends MessageMicro<subcmd0x533$HttpCardV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"string_template_name", "bool_is_recommended", "rpt_msg_card_properties", "rpt_msg_carousel", "rpt_msg_subcards"}, new Object[]{"", Boolean.FALSE, null, null, null}, subcmd0x533$HttpCardV2.class);
    public final PBStringField string_template_name = PBField.initString("");
    public final PBBoolField bool_is_recommended = PBField.initBool(false);
    public final PBRepeatMessageField<subcmd0x533$HttpMapItem> rpt_msg_card_properties = PBField.initRepeatMessage(subcmd0x533$HttpMapItem.class);
    public final PBRepeatMessageField<HttpCarouselUnitV2> rpt_msg_carousel = PBField.initRepeatMessage(HttpCarouselUnitV2.class);
    public final PBRepeatMessageField<subcmd0x533$HttpCardV2> rpt_msg_subcards = PBField.initRepeatMessage(subcmd0x533$HttpCardV2.class);

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class HttpCarouselUnitV2 extends MessageMicro<HttpCarouselUnitV2> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_card_properties"}, new Object[]{null}, HttpCarouselUnitV2.class);
        public final PBRepeatMessageField<subcmd0x533$HttpMapItem> rpt_msg_card_properties = PBField.initRepeatMessage(subcmd0x533$HttpMapItem.class);
    }
}
