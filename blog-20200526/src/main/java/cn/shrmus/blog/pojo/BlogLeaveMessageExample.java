package cn.shrmus.blog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogLeaveMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogLeaveMessageExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMessageIdIsNull() {
            addCriterion("message_id is null");
            return (Criteria) this;
        }

        public Criteria andMessageIdIsNotNull() {
            addCriterion("message_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessageIdEqualTo(Integer value) {
            addCriterion("message_id =", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotEqualTo(Integer value) {
            addCriterion("message_id <>", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThan(Integer value) {
            addCriterion("message_id >", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_id >=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThan(Integer value) {
            addCriterion("message_id <", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThanOrEqualTo(Integer value) {
            addCriterion("message_id <=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdIn(List<Integer> values) {
            addCriterion("message_id in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotIn(List<Integer> values) {
            addCriterion("message_id not in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdBetween(Integer value1, Integer value2) {
            addCriterion("message_id between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("message_id not between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andMessagePidIsNull() {
            addCriterion("message_pid is null");
            return (Criteria) this;
        }

        public Criteria andMessagePidIsNotNull() {
            addCriterion("message_pid is not null");
            return (Criteria) this;
        }

        public Criteria andMessagePidEqualTo(Integer value) {
            addCriterion("message_pid =", value, "messagePid");
            return (Criteria) this;
        }

        public Criteria andMessagePidNotEqualTo(Integer value) {
            addCriterion("message_pid <>", value, "messagePid");
            return (Criteria) this;
        }

        public Criteria andMessagePidGreaterThan(Integer value) {
            addCriterion("message_pid >", value, "messagePid");
            return (Criteria) this;
        }

        public Criteria andMessagePidGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_pid >=", value, "messagePid");
            return (Criteria) this;
        }

        public Criteria andMessagePidLessThan(Integer value) {
            addCriterion("message_pid <", value, "messagePid");
            return (Criteria) this;
        }

        public Criteria andMessagePidLessThanOrEqualTo(Integer value) {
            addCriterion("message_pid <=", value, "messagePid");
            return (Criteria) this;
        }

        public Criteria andMessagePidIn(List<Integer> values) {
            addCriterion("message_pid in", values, "messagePid");
            return (Criteria) this;
        }

        public Criteria andMessagePidNotIn(List<Integer> values) {
            addCriterion("message_pid not in", values, "messagePid");
            return (Criteria) this;
        }

        public Criteria andMessagePidBetween(Integer value1, Integer value2) {
            addCriterion("message_pid between", value1, value2, "messagePid");
            return (Criteria) this;
        }

        public Criteria andMessagePidNotBetween(Integer value1, Integer value2) {
            addCriterion("message_pid not between", value1, value2, "messagePid");
            return (Criteria) this;
        }

        public Criteria andMessageIsreplyIsNull() {
            addCriterion("message_isreply is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsreplyIsNotNull() {
            addCriterion("message_isreply is not null");
            return (Criteria) this;
        }

        public Criteria andMessageIsreplyEqualTo(Integer value) {
            addCriterion("message_isreply =", value, "messageIsreply");
            return (Criteria) this;
        }

        public Criteria andMessageIsreplyNotEqualTo(Integer value) {
            addCriterion("message_isreply <>", value, "messageIsreply");
            return (Criteria) this;
        }

        public Criteria andMessageIsreplyGreaterThan(Integer value) {
            addCriterion("message_isreply >", value, "messageIsreply");
            return (Criteria) this;
        }

        public Criteria andMessageIsreplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_isreply >=", value, "messageIsreply");
            return (Criteria) this;
        }

        public Criteria andMessageIsreplyLessThan(Integer value) {
            addCriterion("message_isreply <", value, "messageIsreply");
            return (Criteria) this;
        }

        public Criteria andMessageIsreplyLessThanOrEqualTo(Integer value) {
            addCriterion("message_isreply <=", value, "messageIsreply");
            return (Criteria) this;
        }

        public Criteria andMessageIsreplyIn(List<Integer> values) {
            addCriterion("message_isreply in", values, "messageIsreply");
            return (Criteria) this;
        }

        public Criteria andMessageIsreplyNotIn(List<Integer> values) {
            addCriterion("message_isreply not in", values, "messageIsreply");
            return (Criteria) this;
        }

        public Criteria andMessageIsreplyBetween(Integer value1, Integer value2) {
            addCriterion("message_isreply between", value1, value2, "messageIsreply");
            return (Criteria) this;
        }

        public Criteria andMessageIsreplyNotBetween(Integer value1, Integer value2) {
            addCriterion("message_isreply not between", value1, value2, "messageIsreply");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorIsNull() {
            addCriterion("user_id_author is null");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorIsNotNull() {
            addCriterion("user_id_author is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorEqualTo(Integer value) {
            addCriterion("user_id_author =", value, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorNotEqualTo(Integer value) {
            addCriterion("user_id_author <>", value, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorGreaterThan(Integer value) {
            addCriterion("user_id_author >", value, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id_author >=", value, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorLessThan(Integer value) {
            addCriterion("user_id_author <", value, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorLessThanOrEqualTo(Integer value) {
            addCriterion("user_id_author <=", value, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorIn(List<Integer> values) {
            addCriterion("user_id_author in", values, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorNotIn(List<Integer> values) {
            addCriterion("user_id_author not in", values, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorBetween(Integer value1, Integer value2) {
            addCriterion("user_id_author between", value1, value2, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdAuthorNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id_author not between", value1, value2, "userIdAuthor");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyIsNull() {
            addCriterion("user_id_reply is null");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyIsNotNull() {
            addCriterion("user_id_reply is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyEqualTo(Integer value) {
            addCriterion("user_id_reply =", value, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyNotEqualTo(Integer value) {
            addCriterion("user_id_reply <>", value, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyGreaterThan(Integer value) {
            addCriterion("user_id_reply >", value, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id_reply >=", value, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyLessThan(Integer value) {
            addCriterion("user_id_reply <", value, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyLessThanOrEqualTo(Integer value) {
            addCriterion("user_id_reply <=", value, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyIn(List<Integer> values) {
            addCriterion("user_id_reply in", values, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyNotIn(List<Integer> values) {
            addCriterion("user_id_reply not in", values, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyBetween(Integer value1, Integer value2) {
            addCriterion("user_id_reply between", value1, value2, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andUserIdReplyNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id_reply not between", value1, value2, "userIdReply");
            return (Criteria) this;
        }

        public Criteria andMessagePublishTimeIsNull() {
            addCriterion("message_publish_time is null");
            return (Criteria) this;
        }

        public Criteria andMessagePublishTimeIsNotNull() {
            addCriterion("message_publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andMessagePublishTimeEqualTo(Date value) {
            addCriterion("message_publish_time =", value, "messagePublishTime");
            return (Criteria) this;
        }

        public Criteria andMessagePublishTimeNotEqualTo(Date value) {
            addCriterion("message_publish_time <>", value, "messagePublishTime");
            return (Criteria) this;
        }

        public Criteria andMessagePublishTimeGreaterThan(Date value) {
            addCriterion("message_publish_time >", value, "messagePublishTime");
            return (Criteria) this;
        }

        public Criteria andMessagePublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("message_publish_time >=", value, "messagePublishTime");
            return (Criteria) this;
        }

        public Criteria andMessagePublishTimeLessThan(Date value) {
            addCriterion("message_publish_time <", value, "messagePublishTime");
            return (Criteria) this;
        }

        public Criteria andMessagePublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("message_publish_time <=", value, "messagePublishTime");
            return (Criteria) this;
        }

        public Criteria andMessagePublishTimeIn(List<Date> values) {
            addCriterion("message_publish_time in", values, "messagePublishTime");
            return (Criteria) this;
        }

        public Criteria andMessagePublishTimeNotIn(List<Date> values) {
            addCriterion("message_publish_time not in", values, "messagePublishTime");
            return (Criteria) this;
        }

        public Criteria andMessagePublishTimeBetween(Date value1, Date value2) {
            addCriterion("message_publish_time between", value1, value2, "messagePublishTime");
            return (Criteria) this;
        }

        public Criteria andMessagePublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("message_publish_time not between", value1, value2, "messagePublishTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}