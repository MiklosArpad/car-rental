INSERT INTO makes (name) VALUES ('BMW');
INSERT INTO makes (name) VALUES ('Mercedes');
INSERT INTO makes (name) VALUES ('Audi');

INSERT INTO vehicles (license_plate, color, make_id, model) VALUES ('ABC-123', 'piros', (SELECT id FROM makes WHERE name = 'BMW'), 'E36');
INSERT INTO vehicles (license_plate, color, make_id, model) VALUES ('CBA-321', 'kék', (SELECT id FROM makes WHERE name = 'Mercedes'), 'GLA');
INSERT INTO vehicles (license_plate, color, make_id, model) VALUES ('XYZ-987', 'sárga', (SELECT id FROM makes WHERE name = 'Audi'), 'A8');
