package tencent.im.troop_view;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.troop_search_popclassifc.popclassifc$RspBody;
import tencent.im.troop_search_searchtab.searchtab$RspBody;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class troopviewInfo$RspBody extends MessageMicro<troopviewInfo$RspBody> {
    public static final int POPRSB_FIELD_NUMBER = 1;
    public static final int SEARCHRSB_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"popRsb", "searchRsb"}, new Object[]{null, null}, troopviewInfo$RspBody.class);
    public popclassifc$RspBody popRsb = new MessageMicro<popclassifc$RspBody>() { // from class: tencent.im.troop_search_popclassifc.popclassifc$RspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50}, new String[]{"banner_card", "pop_card", "uint32_latitude", "uint32_longitude", "str_city_id", "pop_hotword"}, new Object[]{null, null, 0, 0, "", null}, popclassifc$RspBody.class);
        public popclassifc$BannerCard banner_card = new MessageMicro<popclassifc$BannerCard>() { // from class: tencent.im.troop_search_popclassifc.popclassifc$BannerCard
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_banner_items", "uint32_slid_interval"}, new Object[]{null, 0}, popclassifc$BannerCard.class);
            public final PBRepeatMessageField<popclassifc$BannerItem> rpt_banner_items = PBField.initRepeatMessage(popclassifc$BannerItem.class);
            public final PBUInt32Field uint32_slid_interval = PBField.initUInt32(0);
        };
        public popclassifc$PopCard pop_card = new MessageMicro<popclassifc$PopCard>() { // from class: tencent.im.troop_search_popclassifc.popclassifc$PopCard
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"title_bar", "rpt_pop_items"}, new Object[]{null, null}, popclassifc$PopCard.class);
            public popclassifc$TitleBar title_bar = new popclassifc$TitleBar();
            public final PBRepeatMessageField<popclassifc$PopItem> rpt_pop_items = PBField.initRepeatMessage(popclassifc$PopItem.class);
        };
        public final PBUInt32Field uint32_latitude = PBField.initUInt32(0);
        public final PBUInt32Field uint32_longitude = PBField.initUInt32(0);
        public final PBStringField str_city_id = PBField.initString("");
        public popclassifc$PopHotWordCard pop_hotword = new MessageMicro<popclassifc$PopHotWordCard>() { // from class: tencent.im.troop_search_popclassifc.popclassifc$PopHotWordCard
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"title_bar", "rpt_pop_items"}, new Object[]{null, null}, popclassifc$PopHotWordCard.class);
            public popclassifc$TitleBar title_bar = new popclassifc$TitleBar();
            public final PBRepeatMessageField<popclassifc$HotWordItem> rpt_pop_items = PBField.initRepeatMessage(popclassifc$HotWordItem.class);
        };
    };
    public searchtab$RspBody searchRsb = new MessageMicro<searchtab$RspBody>() { // from class: tencent.im.troop_search_searchtab.searchtab$RspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"rpt_card", "uint32_latitude", "uint32_longitude", "str_city_id"}, new Object[]{null, 0, 0, ""}, searchtab$RspBody.class);
        public final PBRepeatMessageField<searchtab$Card> rpt_card = PBField.initRepeatMessage(searchtab$Card.class);
        public final PBUInt32Field uint32_latitude = PBField.initUInt32(0);
        public final PBUInt32Field uint32_longitude = PBField.initUInt32(0);
        public final PBStringField str_city_id = PBField.initString("");
    };
}
