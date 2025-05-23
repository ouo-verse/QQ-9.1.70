package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.oskplayer.util.SecretUtils;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StTagInfo;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleDitto$StItemInfo extends MessageMicro<QQCircleDitto$StItemInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bizData;
    public final PBRepeatMessageField<FeedCloudCommon$Entry> busiInfo;
    public final PBBytesField busiReport;
    public QQCircleDitto$StButton buttonInfo;
    public final PBStringField datongJsonData;
    public final PBRepeatField<String> des;
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> feeds;
    public final PBRepeatMessageField<FeedCloudMeta$StImage> images;
    public final PBRepeatField<String> relateIds;
    public final PBRepeatMessageField<FeedCloudMeta$StUser> relationUserList;
    public FeedCloudMeta$StTagInfo tag;
    public final PBRepeatMessageField<FeedCloudCommon$Entry> urlInfo;
    public final PBRepeatMessageField<FeedCloudCommon$Entry> userTagList;

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f429300id = PBField.initString("");
    public final PBStringField name = PBField.initString("");

    static {
        String[] strArr = {"id", "name", SecretUtils.DES, "images", "buttonInfo", "urlInfo", "busiInfo", "relateIds", "tag", "bizData", "datongJsonData", "feeds", "busiReport", "relationUserList", "userTagList"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122}, strArr, new Object[]{"", "", "", null, null, null, null, "", null, byteStringMicro, "", null, byteStringMicro, null, null}, QQCircleDitto$StItemInfo.class);
    }

    public QQCircleDitto$StItemInfo() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.des = PBField.initRepeat(pBStringField);
        this.images = PBField.initRepeatMessage(FeedCloudMeta$StImage.class);
        this.buttonInfo = new QQCircleDitto$StButton();
        this.urlInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
        this.busiInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
        this.relateIds = PBField.initRepeat(pBStringField);
        this.tag = new FeedCloudMeta$StTagInfo();
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bizData = PBField.initBytes(byteStringMicro);
        this.datongJsonData = PBField.initString("");
        this.feeds = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
        this.busiReport = PBField.initBytes(byteStringMicro);
        this.relationUserList = PBField.initRepeatMessage(FeedCloudMeta$StUser.class);
        this.userTagList = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    }
}
