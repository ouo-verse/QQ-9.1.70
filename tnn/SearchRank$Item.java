package tnn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SearchRank$Item extends MessageMicro<SearchRank$Item> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 48, 58}, new String[]{"uin", "degree", "match_field", "sub_type", "fileds", "recent_index", "attributes"}, new Object[]{"", 0L, "", "", null, 0, ""}, SearchRank$Item.class);
    public final PBRepeatField<String> attributes;
    public final PBRepeatMessageField<SearchRank$MapFieldEntry> fileds;
    public final PBInt32Field recent_index;
    public final PBRepeatField<String> sub_type;
    public final PBStringField uin = PBField.initString("");
    public final PBUInt64Field degree = PBField.initUInt64(0);
    public final PBStringField match_field = PBField.initString("");

    public SearchRank$Item() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.sub_type = PBField.initRepeat(pBStringField);
        this.fileds = PBField.initRepeatMessage(SearchRank$MapFieldEntry.class);
        this.recent_index = PBField.initInt32(0);
        this.attributes = PBField.initRepeat(pBStringField);
    }
}
