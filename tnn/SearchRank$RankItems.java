package tnn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SearchRank$RankItems extends MessageMicro<SearchRank$RankItems> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"version", "platform", "type", "query", "items"}, new Object[]{0, "", "", "", null}, SearchRank$RankItems.class);
    public final PBInt32Field version = PBField.initInt32(0);
    public final PBStringField platform = PBField.initString("");
    public final PBStringField type = PBField.initString("");
    public final PBStringField query = PBField.initString("");
    public final PBRepeatMessageField<SearchRank$Item> items = PBField.initRepeatMessage(SearchRank$Item.class);
}
