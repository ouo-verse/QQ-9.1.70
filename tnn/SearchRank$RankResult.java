package tnn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SearchRank$RankResult extends MessageMicro<SearchRank$RankResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"error", "error_message", "item_results"}, new Object[]{0, "", null}, SearchRank$RankResult.class);
    public final PBInt32Field error = PBField.initInt32(0);
    public final PBStringField error_message = PBField.initString("");
    public final PBRepeatMessageField<SearchRank$ItemResult> item_results = PBField.initRepeatMessage(SearchRank$ItemResult.class);
}
